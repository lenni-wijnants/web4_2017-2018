import { Component } from '@angular/core';

@Component({
    selector: 'users',
    template: `<h1>{{title}}</h1>
    <nav>
        <a routerLink="/users">Users</a>
    </nav>
    <router-outlet></router-outlet>
    `
})

export class AppComponent {
    title= 'Users of Lenni\'s Chat App';
}
