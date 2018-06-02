import { Injectable }     from '@angular/core';
import { Http }           from '@angular/http';

import { User }  from './user';

import 'rxjs/Rx';
import {Observable} from 'rxjs/Rx';

@Injectable()
export class UserService {

  private usersUrl = 'http://localhost:8080/Controller?action=GetAllUsersHandler';

  constructor(private http: Http) {
  }

  getUsers(): Observable<User[]> {
      return Observable
      .interval(5000)
      .flatMap(() => this.http.get(this.usersUrl).map((data) => data.json()));
  }
}

