Ext.define('LSYS.view.report.Edit', {
    extend: 'Ext.window.Window',
    alias : 'widget.useredit',

    requires: ['Ext.form.Panel'],

    title : '编辑用户',
    layout: 'fit',
    autoShow: true,
    width: 280,
    modal : true,
    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',

                items: [
                    {
                        xtype: 'textfield',
                        name : 'name',
                        fieldLabel: '姓名'
                    },
                    {
                        xtype: 'textfield',
                        name : 'email',
                        fieldLabel: '电子邮件'
                    }
                ]
            }
        ];

        this.buttons = [
            {
                text: '保存',
                action: 'save'
            },
            {
                text: '取消',
                scope: this,
                handler: this.close
            }
        ];

        this.callParent(arguments);
    }
});
