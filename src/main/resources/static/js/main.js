// Without Using Jquery to show mobile menu
function showMenu() {
  document.querySelector("#navlinks").style.right = "0";
}

// Without Using Jquery to close mobile menu
function closeMenu() {
  document.querySelector("#navlinks").style.right = "-400px";
}


$(document).ready(function(){
	
	// Scroll to Section JQuery.
	$("#viewStudentsButton").click(function() {
	    $('html, body').animate({
	        scrollTop: $("#studentFormAndTableSection").offset().top
	    }, 1000);
	});
	
  
 	// AJAX GET request (retrives all students from server)
	GetAllStudents();

  	
  	// AJAX POST request (Send POST request to the server to register a student)
	$("#student-registration-form").submit(function (event) {

        // To prevent that form submits automatically
        event.preventDefault();

        StudentRegisterAjaxSubmit();

    });

});

function GetAllStudents() {
	  $.ajax({
          type: 'GET',
          url: 'http://localhost:8080/students/',
          success: function(studentsArray) {
              //var studentsDiv = $('div#allStudents');
              var studentsTbody = $('#student-table-body');
 
      
              $.each(studentsArray, function(index, student) {
/*                var studentInfo = '<div class="student-info"><p>';
                  studentInfo += 'ID: ' + student.id + '<br>';
                  studentInfo += 'Name: ' + student.name + '<br>';
                  studentInfo += 'Age: ' + student.age + '<br>';
                  studentInfo += 'Mobile: ' + student.mobile + '<br>';
                  studentInfo += 'Address: ' + student.address + '<br>';
                  studentInfo += '</p><hr></div>';
              
                  studentsDiv.append(studentInfo);*/
                  
                  var studentInfo = '<tr class="student-info">';
                  studentInfo += '<th scope="row">' + student.id + '</th>';
                  studentInfo += '<td>' + student.name + '</td>';
                  studentInfo += '<td>' + student.age + '</td>';
                  studentInfo += '<td>' + student.mobile + '</td>';
                  studentInfo += '<td>' + student.address + '</td>';
                  studentInfo += '</tr>';
                  studentsTbody.append(studentInfo);
              })
          },
          error: function() {alert('FAILURE!');
        }
      });
}

function StudentRegisterAjaxSubmit() {

    var student = {}
    //student["id"] = $("#id").val();
    student["name"] = $("#name").val();
    student["age"] = $("#age").val();
    student["mobile"] = $("#mobile").val();
    student["address"] = $("#address").val();
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/students",
        data: JSON.stringify(student),
        dataType: 'json',
        success: function (data) {
            var studentsInfo = $('.student-info');
            studentsInfo.remove();
            GetAllStudents();
        },
        error: function (e) {
            alert(student["name"] + " register failed!");
        }
    });

}
