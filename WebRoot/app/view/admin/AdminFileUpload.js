Ext.define('LSYS.view.admin.AdminFileUpload', {
    extend: 'Ext.window.Window',
    alias : 'widget.adminfileupload',
    layout: 'fit',
    autoShow: true,
    title: '文件上传',
    width: 800,
    height:500,
    frame: true,
    modal : true,
    items:[{
        xtype:'form',
        bodyPadding: '10 10 0',
        defaults: {
            anchor: '100%',
            allowBlank: false,
            msgTarget: 'side',
            labelWidth: 80
        },

        items: [{
            xtype: 'textfield',
            fieldLabel: '派单名',
            name:'text',
            emptyText: '建议以日期结尾，如：宽带0831'
        },{
            xtype: 'filefield',
            id: 'file',
            emptyText: '选择一个文件',
            fieldLabel: '文件',
            name: 'file',
            buttonText: '',
            buttonConfig: {
                iconCls: 'upload-icon'
            },
            validator: function(value){
            var arr = value.split('.');
            if(arr[arr.length-1] != 'xls'){
                return '只支持97-2003版本Excel！';
            }else{
                return true;
            }
            }
        },{
            xtype: 'textareafield',
            name: 'description',
            fieldLabel: '派单描述',
            emptyText: '请填写相关派单描述'
        }],

        buttons: [{
            text: '保存',
            action:'save'
        },{
            text: '重置',
            action:'reset'
        },{
            text: '模板下载',
            action:'download'
        }]
    }]
});
