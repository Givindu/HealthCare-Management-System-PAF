/**
 * 
 */
$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

$(document).on("click", "#bookingBtn", function(event) {
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	var status = validateAppoForm();
	
	if (status != true) {
		$("alertError").text(status);
		$("alertError").show();
		return;
	}

	$("#booingForm").submit();
});

// UPDATE==========================================

$(document).on(
		"click",
		".btnUpdate",
		function(event) {

			$("#hidAppoIdSave").val($(this).closest("tr").find('#hidReadAppoIdUpdate').val());
			
			$("#userId").val($(this).closest("tr").find('td:eq(0)').text());

			$("#docId").val($(this).closest("tr").find('td:eq(1)').text());

			$("#docSpec").val($(this).closest("tr").find('td:eq(2)').text());

			$("#hospId").val($(this).closest("tr").find('td:eq(3)').text());

			$("#date").val($(this).closest("tr").find('td:eq(4)').text());

		});

function validateAppoForm() {

	// CODE

	if ($("#userId").val().trim() == "") {

		return "Insert user id.";

	}


	if ($("#docId").val().trim() == "") {

		return "Insert Hospital Contact Number.";

	}


	if ($("#docSpec").val().trim() == "") {

		return "Insert doctor specialization.";

	}

	if ($("#hospId").val().trim() == "") {

		return "Insert hospital id.";

	}
	
	if ($("#date").val().trim() == "") {

		return "Insert date.";

	}

	return true;

}
