import { EmployeeListComponent } from './../employee-list/employee-list.component';
import { EmployeeService } from './../employee.service';
import { Employee } from './../employee';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  @Input() employee: Employee;
  constructor(
    private employeeService: EmployeeService,
    private listComponent: EmployeeListComponent
  ) {}

  ngOnInit() {}
}
