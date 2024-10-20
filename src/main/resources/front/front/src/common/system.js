export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["新增","查看","修改","删除","用户人数"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除","队长人数"],"menu":"科研队伍","menuJump":"列表","tableName":"keyanduiwu"}],"menu":"科研队伍管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"队伍信息","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","删除"],"menu":"加入队伍","menuJump":"列表","tableName":"jiaruduiwu"}],"menu":"加入队伍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","审核"],"menu":"队伍申请","menuJump":"列表","tableName":"duiwushenqing"}],"menu":"队伍申请管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","删除","成果类型","查看评论","导出"],"menu":"科研成果","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["导出","查看","删除","审核"],"menu":"项目成果申报","menuJump":"列表","tableName":"xiangmuchengguoshenbao"}],"menu":"项目成果申报管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除","查看评论","导出"],"menu":"资源文件","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"信息交流","tableName":"forum"}],"menu":"信息交流"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","加入申请"],"menu":"队伍信息列表","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息模块"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"科研成果列表","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"资源文件列表","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","删除"],"menu":"加入队伍","menuJump":"列表","tableName":"jiaruduiwu"}],"menu":"加入队伍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除"],"menu":"队伍申请","menuJump":"列表","tableName":"duiwushenqing"}],"menu":"队伍申请管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","加入申请"],"menu":"队伍信息列表","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息模块"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"科研成果列表","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"资源文件列表","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["新增","查看","修改","删除"],"menu":"队伍信息","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息管理"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["查看","删除","审核"],"menu":"加入队伍","menuJump":"列表","tableName":"jiaruduiwu"}],"menu":"加入队伍管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论","导出"],"menu":"科研成果","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果管理"},{"child":[{"appFrontIcon":"cuIcon-qrcode","buttons":["新增","查看","修改","删除","导出"],"menu":"项目成果申报","menuJump":"列表","tableName":"xiangmuchengguoshenbao"}],"menu":"项目成果申报管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除"],"menu":"公告信息","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除","查看评论","导出"],"menu":"资源文件","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看","加入申请"],"menu":"队伍信息列表","menuJump":"列表","tableName":"duiwuxinxi"}],"menu":"队伍信息模块"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"科研成果列表","menuJump":"列表","tableName":"keyanchengguo"}],"menu":"科研成果模块"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["查看"],"menu":"公告信息列表","menuJump":"列表","tableName":"gonggaoxinxi"}],"menu":"公告信息模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"资源文件列表","menuJump":"列表","tableName":"ziyuanwenjian"}],"menu":"资源文件模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"科研队伍","tableName":"keyanduiwu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
