# AngularRestUploadUi
For reading csv/text file and updating or retrieving local database.
Filter based on min/max salary and sort by name/login/salary/id
# Usage
Frontend: 1.Change SERVER variable in user.service.ts to point to required backend Rest endpoint.
          2.Run ng serve in terminal to view table
Backend: 1. Change filePath in EmployeeService class to point to csv/text file.
         2. Change Connection.properties to local database
Rest endpoints: "/users" required params: 1. minSalary 2. maxSalary 3. offset 4. limit 5. sort
                "/users/upload" uploasd data in sample/csv file to database
                         
# Interpretation
1. Upload of file by pointing to path in backend.
2. Sorting and filtering data is done in the backend.
