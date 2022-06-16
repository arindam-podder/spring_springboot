function validation(frm){
	//alert(1);
	//empty the error messages 
	document.getElementById("nameErr").innerHTML = "";
	document.getElementById("roleErr").innerHTML = "";
	document.getElementById("dobErr").innerHTML = "";
	document.getElementById("salaryErr").innerHTML = "";
	
	//read frm data into var
	let empName = frm.name.value;
	let empRole = frm.role.value;
	let empDob = frm.dateOfBirth.value;
	let empSalary = frm.salary.value;
	//alert(2);
	let flag = true;
	
	if(empName==""){
		document.getElementById("nameErr").innerHTML = "name required(cs)";
		flag = false;
	}
	else if(empName.length<4 || empName.length>20){
		document.getElementById("nameErr").innerHTML = "name length should be between 4 to 20 chars(cs)";
		flag = false;
	}
	let format = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~0123456789]/ ;
	if(format.test(empName)){
		document.getElementById("nameErr").innerHTML = "name must contains only character(cs)";
		flag = false;
	}
	
	if(empRole=="" || empRole.length==0){
		document.getElementById("roleErr").innerHTML = "role required(cs)";	
		flag = false;	
	}	
	
	if(empDob=="" || empDob.length==0){
		document.getElementById("dobErr").innerHTML = "date of birth required(cs)";	
		flag = false;	
	}
	
	if(empSalary==""){
		document.getElementById("salaryErr").innerHTML = "salary required(cs)";
		flag = false;
	}
	else if (isNaN(empSalary)){
		document.getElementById("salaryErr").innerHTML = "salary must contains number only(cs)";
		flag = false;			
	}
	else if(empSalary<0 || empSalary>100000){
		document.getElementById("salaryErr").innerHTML = "salary must be in the range of 1 to 1lakh (cs)";
		flag = false;					
	}
	
	frm.vflag.value = "yes";
	return flag;
}










