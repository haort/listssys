Ext.define('LSYS.view.Viewport', {
    extend: 'Ext.container.Viewport',
    layout: 'border',
    requires:['LSYS.view.Pie'],
    items: [
    {
         title:'菜单',
	 region:'west',
	 collapsible: true,
       animCollapse: true,
	 margins: '5 0 5 5',
	 width:225,
	 xtype: 'navigation'
    },{
	  region:'center',
         xtype: 'panel',
           margins: '5 0 5 5',
         layout:{
           type:'vbox',
           align:'stretch'
         },
         items:[
          {
           xtype: 'panel',
           layout:'fit',
           title: '统计',
           tbar: [{
               text: '保存报表',
               id:'savePie'
           }, {
               text: '刷新数据',
               id:'reData'
           }],
           items:[{ xtype: 'listpie'}],
           flex:2
           },
          { 
           xtype: 'userlist',
           flex:3
         }]
    }]
});