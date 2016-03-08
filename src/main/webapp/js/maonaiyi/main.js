require.config({
    waitSeconds: 0,
    baseUrl: 'js',
    paths: {
        jqGrid_cn: '3rdparty/jqGrid/js/i18n/grid.locale-cn',
        jqGrid: '3rdparty/jqGrid/js/jquery.jqGrid.min',
        jquery: '3rdparty/jquery/dist/jquery.min',
        custom: 'maonaiyi/custom'
    },
    shim: {
        jqGrid: ['jqGrid_cn'],
        jqGrid_cn: ['jquery']
    },
    urlArgs: '_=' + new Date().getTime()
});
require(['custom'],function(Custom) {
    Custom.initCustom();
});