import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private SERVER = "http://localhost:8080/users?minSalary=0&maxSalary=5000&offset=0&limit=30&sort=+fname"
  constructor(private httpClient: HttpClient) { }
  
  getAllUsers():Observable<any>{
    return this.httpClient.get(this.SERVER);
  }

  createUser(){

  }

  updateUser(){

  }

  deleteUsers(){

  }

}
