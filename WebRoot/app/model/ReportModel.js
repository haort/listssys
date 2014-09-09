Ext.define('LSYS.model.ReportModel', {
	extend : 'Ext.data.Model',

	requires : [ 'Ext.data.reader.Json' ],

	fields : [ 'id', 'servName', 'prodId', 'servAddr', 'accsNbr', 'ty',
			'speed', 'startdt', 'prodTel', 'bipDataNum', 'bipDuration', 'area',
			'rsrc', 'itvProdId', 'packName', 'kpiProdId', 'phone', 'wareName',
			'gridName', 'own', 'deep', 'state', 'chName','remark','formatDate','telephone' ]
});