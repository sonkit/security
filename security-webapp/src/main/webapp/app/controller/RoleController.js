/*
 * File: app/controller/RoleController.js
 *
 * This file was generated by Sencha Architect version 2.2.2.
 * http://www.sencha.com/products/architect/
 *
 * This file requires use of the Ext JS 4.2.x library, under independent license.
 * License of Sencha Architect does not include license for Ext JS 4.2.x. For more
 * details see http://www.sencha.com/license or contact license@sencha.com.
 *
 * This file will be auto-generated each and everytime you save your project.
 *
 * Do NOT hand edit this file.
 */

Ext.define('Security.controller.RoleController', {
    extend: 'Ext.app.Controller',

    models: [
        'Role'
    ],
    stores: [
        'Role'
    ],
    views: [
        'RoleGrid',
        'RoleWin'
    ],

    refs: [
        {
            ref: 'roleGrid',
            selector: 'rolegrid'
        },
        {
            ref: 'roleWin',
            selector: 'rolewin'
        }
    ],

    deleteRole: function(button, e, eOpts) {
        var selModel = this.getRoleGrid().getSelectionModel(),
            roleStore = this.getRoleStore();

        if (selModel.hasSelection()) {
            var record = selModel.getLastSelected();
            Ext.create('Security.model.Role', {
                id: record.get('id')
            }).destroy({
                success: function() {
                    roleStore.reload();
                }
            });
        }
    },

    addRole: function(button, e, eOpts) {
        var win = Ext.widget('rolewin');
        win.show(button);
    },

    editRole: function(button, e, eOpts) {
        var roleWin = Ext.widget('rolewin'),
            roleGrid = this.getRoleGrid(),
            selModel = roleGrid.getSelectionModel();

        if (selModel.hasSelection()) {

            var record = selModel.getLastSelected(),
                form = roleWin.child('form');

            form.loadRecord(record);
            roleWin.show(button);
        }

    },

    saveRole: function(button, e, eOpts) {
        var roleWin = this.getRoleWin(),
            roleGrid = this.getRoleGrid(),
            form = roleWin.child('form');

        if (form.isValid()) {
            Ext.create('Security.model.Role', form.getValues()).save({
                success: function() {
                    roleGrid.getSelectionModel().deselectAll();
                    roleGrid.getStore().reload();
                    roleWin.close();
                }
            });
        }


    },

    init: function(application) {
        this.control({
            "rolegrid button[text='删除']": {
                click: this.deleteRole
            },
            "rolegrid button[text='添加']": {
                click: this.addRole
            },
            "rolegrid button[text='编辑']": {
                click: this.editRole
            },
            "rolewin button[text='保存']": {
                click: this.saveRole
            }
        });
    }

});
