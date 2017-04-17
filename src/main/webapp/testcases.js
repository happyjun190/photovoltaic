//测试用例列表：

/*
 * 按模块编号：
 * 0、用户登录、密码相关
 *
 * 
 * 
 * 
 * 
 * 
 * 
 */
var testCases = [
	{
		author : "吴申俊",
		title : "-1.1 获取测试数据列表",
		url : "/servlet/test/getTestDataList/v100",
		requestBody : '{"authcode": "123456", "userToken": "042a80b917dc45d68d19795e6f34b53d"}'
	},
	{
        author : "吴申俊",
        title : "-1.2 新增测试数据",
        url : "/servlet/test/insertTest/v100",
        requestBody : '{"authcode": "123456", "testInfo":{"id":1, "name":"光伏铁塔测试", "phone":"18565206917", "address":"安徽省合肥市", "company":"光伏铁塔", "note":"安徽省合肥市"}}'
    },
    {
        author : "吴申俊",
        title : "-1.3 更新测试数据",
        url : "/servlet/test/updateTest/v100",
        requestBody : '{"authcode": "123456", "testInfo":{"id":1, "name":"光伏铁塔测试", "phone":"18565206917", "address":"安徽省合肥市", "company":"光伏铁塔", "note":"安徽省合肥市"}}'
    },
    {
        author : "吴申俊",
        title : "-1.4 删除测试数据",
        url : "/servlet/test/deleteTest/v100",
        requestBody : '{"authcode": "123456", "testId": 1}'
    },
    {
        author : "吴申俊",
        title : "0.1 注册账号 ",
        url : "/servlet/auth/regist/v100",
        requestBody : '{"authcode": "123456", "loginName": "admin", "password": "Y2NZV0ZoTVRJek5EVTJZbUppWWc9PQ=="}'
    },
    {
        author : "吴申俊",
        title : "0.2 web登录 ",
        url : "/servlet/auth/webLogin/v100",
        requestBody : '{"authcode": "123456", "loginName": "admin", "password": "e10adc3949ba59abbe56e057f20f883e"}'
    },
    {
        author : "吴申俊",
        title : "0.3 app登录 ",
        url : "/app/auth/login/v100",
        requestBody : '{"authcode": "123456", "loginName": "admin", "password": "e10adc3949ba59abbe56e057f20f883e"}'
    },
    {
        author : "吴申俊",
        title : "1.1 获取首页概览数据 ",
        url : "/app/statastatistic/getStatisticOverView/v100",
        requestBody : '{"authcode": "123456", "userToken": "cf235d953bd443019e2d67fef1379d9e"}'
    },
    {
        author : "吴申俊",
        title : "1.2 获取用户电站列表 ",
        url : "/app/statastatistic/getPowerStaticInfoList/v100",
        requestBody : '{"authcode": "123456", "userToken": "cf235d953bd443019e2d67fef1379d9e"}'
    },
    {
        author : "吴申俊",
        title : "1.2 获取用户逆变器列表 ",
        url : "/app/statastatistic/getInverterInfoList/v100",
        requestBody : '{"authcode": "123456", "userToken": "cf235d953bd443019e2d67fef1379d9e"}'
    }


];

