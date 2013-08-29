var KafJS = new function(){
	
		/**
		 * Inicia función para crear tabla con estilos
		 */
		this.createTable =	function(tableId,json,divId,includeColumns){
	
		/* Creamos la tabla con su respectivo estilo (css) */
		var table = document.createElement("table");
		table.setAttribute("id", tableId);
		table.setAttribute("class", "bordered");
		
		var header = document.createElement("tr");
		for(var j=0; j<includeColumns.length;j++){
			var th = document.createElement("th");
			th.appendChild(document.createTextNode(includeColumns[j].label));
			header.appendChild(th);
		}
		table.appendChild(header);
		
		var tbody = document.createElement("tbody");
		
		for (var i = 0; i < json.length; i++)
		{
			var tr = document.createElement("tr");
			for(var j=0; j<includeColumns.length;j++){
					var td = document.createElement("td");
					if(includeColumns[j].type == "button"){
						var button = document.createElement("button");
						button.setAttribute("id", tableId + "_button_" + includeColumns[j].subType + "_" + json[i][includeColumns[j].name]);
						button.appendChild(document.createTextNode(includeColumns[j].label));
						button.setAttribute("class", (includeColumns[j].type != null)? "button " + includeColumns[j].subType : "button");
						button.setAttribute("onclick",includeColumns[j].action + "('"+ json[i][includeColumns[j].name] +"');");
						td.setAttribute("style","text-align: center;");
						td.appendChild(button);
					}
					else{
						td.appendChild(document.createTextNode(json[i][includeColumns[j].name]));
					}
					tr.appendChild(td);
			
			}		
			tbody.appendChild(tr);
		}
		table.appendChild(tbody);
		
		$(divId).appendChild(table);
	};
	
	/**
	 * Función para crear botón con estilos
	 */
	this.createButton = function(buttonId, buttonText, buttonType, onclick, divId){
		var button = document.createElement("button");
		button.setAttribute("id", buttonId);
		button.appendChild(document.createTextNode(buttonText));
		button.setAttribute("class", (buttonType != null)? "button " + buttonType : "button");
		button.setAttribute("onclick", onclick);
		$(divId).appendChild(button);
	};
};