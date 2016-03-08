define(['jquery'], function($){
    function init() {
        $('#custom').jqGrid({
            url: 'api/invheaderList',
            datatype: 'json',
            mtype: 'GET',
            colNames: ['Inv No', 'Date', 'Amount', 'Tax', 'Total', 'Notes'],
            colModel: [
                { name: 'invid', width: 55 },
                { name: 'invdate', width: 90 },
                { name: 'amount', width: 80, align: 'right' },
                { name: 'tax', width: 80, align: 'right' },
                { name: 'total', width: 80, align: 'right' },
                { name: 'note', width: 150, sortable: false }
            ],
            pager: '#pager',
            rowNum: 10,
            rowList: [10, 20, 30],
            sortname: 'invid',
            sortorder: 'desc',
            viewrecords: true,
            gridview: true,
            autoencode: true,
            regional: 'cn',
            caption: 'custom'
        });
    };
    return {
        initCustom: init
    };
});