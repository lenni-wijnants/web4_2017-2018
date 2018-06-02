import { Component, OnInit }   from '@angular/core';

import { User }                from './user';
import { UserService }         from './user.service';

import 'rxjs/Rx';

@Component({
  selector: 'all-users',
  templateUrl: './users.component.html',
  styleUrls: [ './users.component.css' ]
})

export class UsersComponent implements OnInit {
  users: User[];

  constructor(private userService: UserService) { }

  getUsers(): void {
      this.userService.getUsers()
          .subscribe(data => this.users = data);
  }

  ngOnInit(): void {
    this.getUsers();
  }
}
