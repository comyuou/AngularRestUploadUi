import { Component , ViewChild} from '@angular/core';
import { UserService } from './user.service';
import { User } from './user';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';

const ELEMENT_DATA: User[] = [];
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'user-demo';
  @ViewChild(MatPaginator) paginator: MatPaginator;
  displayedColumns: string[] = ['id', 'name', 'login', 'salary'];
  dataSource = new MatTableDataSource<User>(ELEMENT_DATA);
  constructor(private userService:UserService){
    this.userService.getAllUsers().subscribe((v)=>{
      this.dataSource=v;
      this.dataSource.paginator = this.paginator;
    });
  }
  ngOnInit() {
  }
  public users:any=[];
  }


