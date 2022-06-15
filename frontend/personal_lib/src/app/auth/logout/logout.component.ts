import { HttpClient } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    public http: HttpClient,
  ) {
    
   }

  ngOnInit(): void {
    this.http.get('/logout').subscribe((data) => {console.log(data)});
  }

}
