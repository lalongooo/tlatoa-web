/**
 * 
 */

$(document).ready(function() {
	var dragSrcEl = null;
	
	$('.draggable').bind('dragstart', function(e){
		dragSrcEl = this;

		e.originalEvent.dataTransfer.effectAllowed = 'move';
		e.originalEvent.dataTransfer.setData('text/html', this.innerHTML);
	});
	
	$('.draggable').bind('dragenter', function(){
		$(this).addClass('over');
	});
	
	$('.draggable').bind('dragover', function(e){
		if (e.preventDefault) {
		    e.preventDefault(); // Necessary. Allows us to drop.
		  }

		  e.originalEvent.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.

		  return false;
	});
	
	$('.draggable').bind('dragleave', function(){
		$(this).removeClass('over');
	});
	
	$('.draggable').bind('drop', function(e){
		// this / e.target is current target element.
		
		if (e.originalEvent.stopPropagation) {
			e.originalEvent.stopPropagation(); // stops the browser from redirecting.
		}
			
		// See the section on the DataTransfer object.
		if (dragSrcEl != this) {
			// Set the source column's HTML to the HTML of the column we dropped on.
		    dragSrcEl.innerHTML = this.innerHTML;
		    this.innerHTML = e.originalEvent.dataTransfer.getData('text/html');
		}
			
		return false;
	});
	
	$('.draggable').bind('dragend', function(){
		//$(this).removeClass('over');
	});
	
});