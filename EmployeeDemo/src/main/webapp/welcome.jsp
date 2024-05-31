<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="addEmployee" method="get">
    <h3>Welcome ${name} please register Employee details</h3>
    Enter employee Id : <input type="text" name="id"><br><br>
    Enter employee name : <input type="text" name="name"><br><br>
    Enter employee email : <input type="text" name="email"><br><br>
    Enter employee Phone Number: <input type="text" name="phone"><br><br>
    Enter employee department : <input type="text" name="department"><br><br>
    Enter employee Skill : <input type="text" name="skill"><br><br>
<input type="submit">
    
    </form><br><br>

    <h4>To fetch employee data</h4>
    <form action="fetchEmployee">
        Enter employee Id : <input type="text" name="id"><br><br>
        <input type="submit">

    </form><br><br>
    <h3>to update employee</h3>
    <form action="updateEmployee">
        Enter employee Id : <input type="text" name="id"><br><br>
        Enter employee name : <input type="text" name="name"><br><br>
        Enter employee email : <input type="text" name="email"><br><br>
        Enter employee Phone Number: <input type="text" name="phone"><br><br>
        Enter employee department : <input type="text" name="department"><br><br>
        Enter employee Skill : <input type="text" name="skill"><br><br>
    <input type="submit">

    </form><br><br>

<h4>To delete employee data</h4>
<form action="deleteEmployee">
    Enter employee Id : <input type="text" name="id"><br><br>
    <input type="submit">

</form>
</body>
</html>