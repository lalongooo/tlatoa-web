$(document).ready(function() {
	$('.accessLevel').each(function() {
		$(this).find('.editButton').click(editAccessLevel);
	});
});

var editAccessLevel = function () {
	$('#accessLevelModal #roleEditForm').prop('action', $(this).closest('tr').find('#target').val());
	$('#accessLevelModal #userName').val($(this).closest('tr').find('#userName').val());
	
	$(this).closest('tr').find('.role').each(function() {
		$('#accessLevelModal #roleId option#' + $(this).val()).prop("selected", true);	
	});
	
	$('#accessLevelModal').modal('toggle');
};