$(document).ready(function () {
			//1.hiding error section
			$("#shipmentModeError").hide();
			$("#shipmentCodeError").hide();
			$("#enableShipmentError").hide();
			$("#shipmentGradeError").hide();
			$("#shipmentDescriptionError").hide();

			//2. Defining error variables
			var shipmentModeError = false;
			var shipmentCodeError = false;
			var enableShipmentError = false;
			var shipmentGradeError = false;
			var shipmentDescriptionError=false;

			//3.validating the function
			function validate_shipmentMode() {
				var val = $("#shipmentMode").val();
				if (val == " ") {
					$("#shipmentModeError").show();
					$("#shipmentModeError").html("Please Select <b>any Option </b>");
					$("#shipmentModeError").css('color', 'red');
					shipmentModeError = false;
				} else {
					$("#shipmentModeError").hide();
					shipmentModeError = true;
				}
				return shipmentModeError;
			}//function

			function validate_shipmentcode() {
				var val = $("#shipmentCode").val();
				var exp = /^[A-Z0-9\.\-]{4,12}$/
				if (val == "") {
					$("#shipmentCodeError").show();
					$("#shipmentCodeError").html("Please enter <b> valid </b> one");
					$("#shipmentCodeError").css('color', 'red');
					shipmentCodeError = false;
				} else if (!exp.test(val)) {
					$("#shipmentCodeError").show();
					$("#shipmentCodeError").html(" enter <b> valid </b> one");
					$("#shipmentCodeError").css('color', 'green');
					shipmentCodeError = false;
				} else {
					$("#shipmentCodeError").hide();
					shipmentCodeError = true;
				}
				return shipmentCodeError;
			}

			function validate_enableShipmentError() {

				var check = $('[name="enableShipment"]:checked').length;
				if (check == 0) {
					$("#enableShipmentError").show();
					$("#enableShipmentError").html('Please select <b> one check </b> box');
					$("#enableShipmentError").css('color', 'red');
					enableShipmentError = false;
				} else {
					$("#enableShipmentError").hide();
					enableShipmentError = true;
				}
				return enableShipmentError;
			}

			function validate_shipmentGradeError(){
				var check=$('[name="shipmentGrade"]:checked').length;
				if(check==0){
					$("#shipmentGradeError").show();
					$("#shipmentGradeError").html('Please <b> choose one </b> option');
					$("#shipmentGradeError").css('color','red');
					shipmentGradeError=false;

				}else{
					$("#shipmentGradeError").hide();
					shipmentGradeError=true;
				}
				return shipmentGradeError;
			}
			function validate_shipmentDescriptionError(){
				 var text=$("#shipmentDescription").val();
				 var exp=/[A-Za-z0-9\.\,\s\-]{5,125}/;
				 if(text==''){
					 $("#shipmentDescriptionError").show();
					 $("#shipmentDescriptionError").html('Please <b> Enter some </b> Text');
					 $("#shipmentDescriptionError").css('color','red');
					 shipmentDescriptionError=false;
				 }
				 else if(!exp.test(text))
				 {
					 $("#shipmentDescriptionError").show();
					 $("#shipmentDescriptionError").html('Please <b> Enter  valid </b> Text');
					 $("#shipmentDescriptionError").css('color','green'); 
					 shipmentDescriptionError=false;
				 }else{
					$("#shipmentDescriptionError").hide();
					shipmentDescriptionError=true;
				 }
				 return shipmentDescriptionError;
			}
			//4.link with events
			$("#shipmentMode").change(function () {
				validate_shipmentMode();
			})

			$("#shipmentCode").keyup(function () {
				validate_shipmentcode();
			})

			$("[name='enableShipment']").change(function () {
				validate_enableShipmentError();
			})
			$("[name='shipmentGrade']").change(function(){
				validate_shipmentGradeError();
			})

			$("#shipmentDescription").keyup(function(){
				validate_shipmentDescriptionError();
			})
			//5. Form submit
			$("#shipRegForm").submit(function () {
				validate_shipmentMode();
				validate_shipmentcode();
				validate_enableShipmentError();
				validate_shipmentGradeError();
				validate_shipmentDescriptionError();
				if (shipmentModeError && shipmentCodeError && enableShipmentError
				                      && shipmentGradeError && shipmentDescriptionError)  {
					return true;
				} else {
					return false;
				}
			});


		});//end