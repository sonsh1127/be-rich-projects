/**
 * 
 */
function getInsuranceList() {
	$.ajax({
		url : "insure/list",
		type : "get",
		dataType : "json",
		success : function(data) {
			makeOption(data);
		}
	});
};
function makeOption(data) {
	var insureSelect = $("#insure-title");
	insureSelect.empty();
	$(data).each(function() {
		$("<option>").text(this).val(this).appendTo(insureSelect);
	});
};

function makeDiseaseCategory1() {
	var diseaseCategory1 = $("#diseaseCategory1");
	diseaseCategory1.empty();
	var c = [ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
			"N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" ];
	for (var i = 0; i < c.length; i++) {
		$("<option>").text(c[i]).val(c[i]).appendTo(diseaseCategory1);
	}
};
function makeDiseaseCategory2() {

	var diseaseCategory2 = $("#diseaseCategory2");
	diseaseCategory2.empty();

	for (var i = 0; i < 100; i++) {
		$("<option>").text(pad(i,2)).val(pad(i,2)).appendTo(diseaseCategory2);
	}
};
function makeDiseaseCategory3() {

	var diseaseCategory3 = $("#diseaseCategory3");
	diseaseCategory3.empty();
	for (var i = 0; i < 100; i++) {
		$("<option>").text(pad(i,2)).val(pad(i,2)).appendTo(diseaseCategory3);
	}
}
function makeDiseaseCategory4() {

	var diseaseCategory4 = $("#diseaseCategory4");
	diseaseCategory4.empty();
	var c = [ "", "+" ];
	for (var i = 0; i < c.length; i++) {
		$("<option>").text(c[i]).val(c[i]).appendTo(diseaseCategory4);
	}
};
function makeTreatementDays() {

	var treatementDays = $("#treatementDays");
	treatementDays.empty();
	for (var i = 1; i <= 50; i++) {
		$("<option>").text(pad(i,2)).val(pad(i,2)).appendTo(treatementDays);
	}
};
function pad(n, width) {
	n = n + '';
	return n.length >= width ? n : new Array(width - n.length + 1).join('0')
			+ n;
};
