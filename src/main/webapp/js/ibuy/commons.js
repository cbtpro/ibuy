var commons = commons || function() {
	
	function getUserInfo() {
		return JSON.stringify(sessionStorage.getItem('userInfo'));
	}
	function setUserInfo(user) {
		var userInfo = {
				username: user.username || 'aa'
		};
		sessionStorage.setItem('userInfo', JSON.stringify(userInfo));
	}
	
	return {
		getUserInfo: getUserInfo,
		setUserInfo: setUserInfo
	};
}();