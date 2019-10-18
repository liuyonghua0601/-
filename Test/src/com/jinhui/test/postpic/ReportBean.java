package com.jinhui.test.postpic;

/**
 * cm
 * ReportingCentre
 * 2009-10-28 下午01:33:35
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @author cm 举报录入beans
 */
@SuppressWarnings("serial")
public class ReportBean implements Serializable {

	private Integer id;

	private String name; // 举报人姓名

	private Integer sex; // 性别，0-女，1-男

	private String email; // 邮箱

	private String tel; // 电话

	private String provincecode; // 省份码，来自系统编码

	private String citycode; // 城市码 来自系统编码类型：城市码
	
	private String countycode;//区县编码

	private String address; // 通讯地址

	private Integer isspeciareporter; // 是否是举报专业户。0-否 1-是

	private String webname; // 被举报的网站名称

	private String siteurl; // 被举报的网站网址

	private String pageurl; // 信息所在的详细网址 支持多条，使用回车做为分隔符

	private String typecatalog; // 危害信息类型，大类

	private String typecode; // 危害信息类型，小类，可空

	private String waycode; // 危害方式码

	private Date reporttime; // 举报时间，自动记录

	private Integer reporttype; // 被举报类型
	/*
	 * 0-普通网站 1-搜索引擎类 2-手机APP 3-被举报人(含单位) 4-被举报网站 5-被举报QQ号码 6-即时通讯帐号 7-网盘帐号
	 */

	private Integer seid; // 库里有的搜索引擎匹配信息编号。当 ReportTpe=1 的时候，提供
							// 库里已匹配URL的引擎列表供选择，选择其他则为空。

	private String otherengine;//其他搜索引擎名称，当选择搜索引擎为其他时填写
	
	private String keyword; // 搜索关键字,当 ReportType为1的时候需要填写.多个关键字用回车做分隔符

	private String content; // 举报信息内容

	private String reporterip;// 举报者IP地址，自动记录

	private String siteip;// 被举报的服务器IP地址

	private String sitearea;// 被举报的服务器所在区域

	private Integer siteareatype;// 被举报的服务器所在区域类型0-境内 1-境外

	private String recordnumber;// 被举报网站备案号

	private String recordname;// 被举报网站备案的主办单位名称

	private String recordnature;// 被举报网站备案的主办单位性质

	private Integer reportusertype;// 举报人类型。0-普通举报用户1-注册举报用户 2-义务监督员 <录入的算普通用户>

	private Integer createtype;// 举报信息类型：0-外部举报 1-举报中心工作人员录入的举报 2-专项任务
								// 3-网信办工作人员录入

	private Integer reportway;// 举报方式。0-邮件、1-电话、2-网站、3-手机app、4-其他

	private String reporterid;// 注册举报人uuid或者义务监督员sup_id，当reportusertype=1或者2时写入

	private Integer isduplication;// 是否为重复举报。0-否,1-是 (默认为0)

	private String duprepid;// 重复举报的举报编号字符串。多个重复举报编号使用逗号分隔。(例如 1,2 )

	private Integer bullornotid;// 关联的封堵编号或者通知删除编号。

	private Date exposuredate;// 处置日期，只有状态转为 已处置的情况下填写。

	private String contract;// 联系方式。状态为部分处理进行处理的时候填写

	private Date checkdate;// 复查时间。状态为部分处理和全部处理进行复查的时候写入。

	private Integer checkresult;// 复查结果。0-不能访问 1-能访问 2-部分能访问

	private Integer attflag;// 0-无附件；1-有附件,默认0

	private String mcode;// 用户(客户端)代码。如果为APP举报则不为空，如果为网站举报则为空

	private Integer anonymous;// 是否匿名举报。0-否 1-是,默认0

	private Integer appsourcecod;// 下载源类别码。当被举报类型为手机APP时填写。
	/*
	 * 0：其他 1：安卓市场 2：安智市场 3：机锋市场 4：应用汇 5：豌豆荚 6：91手机助手 7：MIUI手机超市 8：360手机助手
	 */

	private String appsourcename;// 其他下载源，当被举报类型为手机APP并且下载源类别为0时填写
	
	private String col;// 举报的APP所在栏目。当被举报类型为手机APP时填写
	
	/*
	 * 1:法律法规底线 2:社会主义制度底线 3:国家利益底线 4:公民合法权益底线 5:社会公共秩序底线 6:道德风尚底线 7:信息真实性底线
	 */

	private String nameorunit;// 姓名或者单位。当举报类型为'被举报人(含单位)'时不为空
	
	private String contactphone;// 联系电话。当举报类型为'被举报人(含单位)'时不为空
	
	private String areaprovince;// 地域<省份>,来自系统编码。当举报类型为'被举报人(含单位)'时不为空
	
	private Integer moneyis;// 是否有经济损失 0:否 1 :是(举报类型为5时，不为空)
	
	private String money;// 损失金额 (moneyis为1是不为空)
	
	private String qqnumber;// QQ号码或群号码(举报类型为5时，不为空)
	
	private String idcardnumber;// 身份证号码
	
	private String reportwork;// 举报人的工作单位和职务
	
	private Integer reportpolitical;// 政治面貌: -1:未知 0:党员 1:团员 2:群众
	
	private String zipcode;// 邮编
	
	private String reportertype;// 被举报人分类--被举报类型分类表的代码
	
	private String reporterdestype;// 被举报人详细分类--被举报类型分类表的代码
	
	private String reporterdesother;// 被举报人详细分类-选择其他部分后手工填写的值。只有举报人分类为'国家公职人员'且详细分类为'其他部门'时不为空
	
	private String sitetype;// 被举报网站分类--被举报类型分类表的代码
	
	private String sitedestype;// 被举报网站详细分类--被举报类型分类表的代码
	
	private Integer toolname;// 通讯工具名称。0-微信 1-YY 2-QQ 3-米聊 4-其他 当举报类型为通讯账号时有效
	
	private Integer drivename;// 网盘名称。0-百度云盘 1-360网盘 2-115网盘 3-其他
	
	private String othername;// 其他名称。当即时通讯和网盘名称选择其他时填写
	
	private String accountname;// 帐号名称。
	
	private Integer accountnature;// 帐号性质。0-个人帐号 1-公众或群帐号 2-其他
	
	private Integer rewardtype;// 奖励类型。-1：未处理 0-拟定奖励 1-拟定捐赠 2-奖励已发送
	
	
	private String recognitioncode; // 唯一识别码

	/**
	 * status 状态
	 *	0-等待预处理1- 正在预处理2-预处理完毕等待人工处理
		20-全部处理21-部分处理22-中心已处置23-垃圾信息
		30-网站未处理31-网站已整改32-网站垃圾33-未处理(网站转回中心)
		40-网信办未处理41-网信办全部处理42-网信办部分处理43-网信办垃圾44-未处理(网信办转回中心)
		50-删帖等待预处理处理51-删帖未处理52-删帖待定53-删帖有效54-删帖垃圾
		60-专项等待预处理61-专项未处理62-专项处理中63-专项已处置64-专项垃圾
		70-诈骗等待预处理
		71-诈骗未审核
		72-诈骗已审核
		73-诈骗已转交
		74-诈骗无效
	 */
	private Integer status;

	/**
	 * statuslast 上一个状态
	 * 
	 *0-等待预处理1- 正在预处理2-预处理完毕等待人工处理
		20-全部处理21-部分处理22-中心已处置23-垃圾信息
		30-网站未处理31-网站已整改32-网站垃圾33-未处理(网站转回中心)
		40-网信办未处理41-网信办全部处理42-网信办部分处理43-网信办垃圾44-未处理(网信办转回中心)
		50-删帖等待预处理处理51-删帖未处理52-删帖待定53-删帖有效54-删帖垃圾
		60-专项等待预处理61-专项未处理62-专项处理中63-专项已处置64-专项垃圾
		70-诈骗等待预处理
		71-诈骗未审核
		72-诈骗已审核
		73-诈骗已转交
		74-诈骗无效
	 */
	private Integer statuslast;
	
	private Date latestdate; // 最新的时间，每次状态改变的时候变更
	
	private Integer refagencyid; //举报中心转交处理的机构编号。 转网信办的则此列为网信办编号，转网站的则此列为网站编号
	
	private Date removetime; // 迁移时间

	private Integer ismanualwpss;//是否手动截图0:是 1:否
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	private List<String> urllist; //详细网址拆分集合
	
	private Integer textnum;//违规文字数
	private Integer pornimgnum;//涉黄图片数
	private Integer attachpornimg;//附件涉黄图片数，默认值0
	private String provincecodename;//省 具体名字
	private String citycodename;//市 具体名字
	private String membername;//网站名字
	private String societyname;//网信办名字
	
	private String catalogname; // 危害信息类型，大类          联查
	private String typecodename; // 危害信息类型，小类，可空             联查
	private String waycodename; // 危害方式           联查
	private String seidname;//搜索引擎 联查
	private String areaprovincename;//联查
	
	private String codeitemid;//关联t_syscodeitem表中kindid=03类型的itemid，回复内容码
	private Integer memsocietyid;//录入网站网信办ID，关联t_memsociety表的id


	private Integer cardtype;//证件类型
	/**
	0-身份证
	1-军官证
	2-护照
	3-驾驶证
	4-学生证
	5-警官证
	6-其他
	*/
	private Date happentime;//事件发生时间
	private Integer isvictim;//是否直接受害人（0：是/1：否）
	private Integer networkservice;//网络应用服务
	/**
	0-app
	1-QQ
	2-淘宝旺旺
	3-YY语音
	4-微信
	5-QT语音
	6-UC
	7-其他*/
	private String illegalappname;//违法应用账号（APP名称）
	private String suspect_name;//嫌疑人昵称
	private String suspect_tel;//嫌疑人电话
	private String suspect_email;//嫌疑人邮箱
	private Integer suspect_paytype_big;//嫌疑人收款方式一级类
	//0-银行卡
	//1-第三方支付平台

	private Integer suspect_paytype_smart;//嫌疑人收款方式
	/**
	 * 嫌疑人收款方式
		0-	一般储蓄卡
		1-	个人信用卡
		2-	支付宝
		3-  财付通
		4-	网易支付
		5-	百度钱包
		6-	京东钱包
		7-	360支付
		8-	快钱钱包
		9-	盛付通
		10-	易付宝钱包
		11-	国付宝
		12-	钱袋宝
		13-	融宝
		14-	壹钱包
		15-	盒子支付
		16-	讯付
		17-	完美
		18-	其他

	 * @return
	 */
	private String suspect_payaccount;//嫌疑人收款账号
	private String suspect_sheng;//嫌疑人收款账户所在地(省)
	private String suspect_shi;//嫌疑人收款账户所在地（市）
	private String suspect_xian;//嫌疑人收款账户所在地（县）
	private String victim_sheng;//受害人所属地（省）
	private String victim_shi;//受害人所属地（市）
	private String victim_xian;//受害人所属地（县）
	
	private String mesonlyid;//编号。时间<8位，年2位+月2位+日2位+小时2位> + 危害类型<2位> + 本记录的主键id后6位
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getProvincecode() {
		return provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIsspeciareporter() {
		return isspeciareporter;
	}

	public void setIsspeciareporter(Integer isspeciareporter) {
		this.isspeciareporter = isspeciareporter;
	}

	public String getWebname() {
		return webname;
	}

	public void setWebname(String webname) {
		this.webname = webname;
	}

	public String getSiteurl() {
		return siteurl;
	}

	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}

	public String getPageurl() {
		return pageurl;
	}

	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}

	public String getTypecatalog() {
		return typecatalog;
	}

	public void setTypecatalog(String typecatalog) {
		this.typecatalog = typecatalog;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getWaycode() {
		return waycode;
	}

	public void setWaycode(String waycode) {
		this.waycode = waycode;
	}

	public Date getReporttime() {
		return reporttime;
	}

	public void setReporttime(Date reporttime) {
		this.reporttime = reporttime;
	}

	public Integer getReporttype() {
		return reporttype;
	}

	public void setReporttype(Integer reporttype) {
		this.reporttype = reporttype;
	}

	public Integer getSeid() {
		return seid;
	}

	public void setSeid(Integer seid) {
		this.seid = seid;
	}

	public String getOtherengine() {
		return otherengine;
	}

	public void setOtherengine(String otherengine) {
		this.otherengine = otherengine;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReporterip() {
		return reporterip;
	}

	public void setReporterip(String reporterip) {
		this.reporterip = reporterip;
	}

	public String getSiteip() {
		return siteip;
	}

	public void setSiteip(String siteip) {
		this.siteip = siteip;
	}

	public String getSitearea() {
		return sitearea;
	}

	public void setSitearea(String sitearea) {
		this.sitearea = sitearea;
	}

	public Integer getSiteareatype() {
		return siteareatype;
	}

	public void setSiteareatype(Integer siteareatype) {
		this.siteareatype = siteareatype;
	}

	public String getRecordnumber() {
		return recordnumber;
	}

	public void setRecordnumber(String recordnumber) {
		this.recordnumber = recordnumber;
	}

	public String getRecordname() {
		return recordname;
	}

	public void setRecordname(String recordname) {
		this.recordname = recordname;
	}

	public String getRecordnature() {
		return recordnature;
	}

	public void setRecordnature(String recordnature) {
		this.recordnature = recordnature;
	}

	public Integer getReportusertype() {
		return reportusertype;
	}

	public void setReportusertype(Integer reportusertype) {
		this.reportusertype = reportusertype;
	}

	public Integer getCreatetype() {
		return createtype;
	}

	public void setCreatetype(Integer createtype) {
		this.createtype = createtype;
	}

	public Integer getReportway() {
		return reportway;
	}

	public void setReportway(Integer reportway) {
		this.reportway = reportway;
	}

	public String getReporterid() {
		return reporterid;
	}

	public void setReporterid(String reporterid) {
		this.reporterid = reporterid;
	}

	public Integer getIsduplication() {
		return isduplication;
	}

	public void setIsduplication(Integer isduplication) {
		this.isduplication = isduplication;
	}

	public String getDuprepid() {
		return duprepid;
	}

	public void setDuprepid(String duprepid) {
		this.duprepid = duprepid;
	}

	public Integer getBullornotid() {
		return bullornotid;
	}

	public void setBullornotid(Integer bullornotid) {
		this.bullornotid = bullornotid;
	}

	public Date getExposuredate() {
		return exposuredate;
	}

	public void setExposuredate(Date exposuredate) {
		this.exposuredate = exposuredate;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}

	public Integer getCheckresult() {
		return checkresult;
	}

	public void setCheckresult(Integer checkresult) {
		this.checkresult = checkresult;
	}

	public Integer getAttflag() {
		return attflag;
	}

	public void setAttflag(Integer attflag) {
		this.attflag = attflag;
	}

	public String getMcode() {
		return mcode;
	}

	public void setMcode(String mcode) {
		this.mcode = mcode;
	}

	public Integer getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}

	public Integer getAppsourcecod() {
		return appsourcecod;
	}

	public void setAppsourcecod(Integer appsourcecod) {
		this.appsourcecod = appsourcecod;
	}

	public String getAppsourcename() {
		return appsourcename;
	}

	public void setAppsourcename(String appsourcename) {
		this.appsourcename = appsourcename;
	}

	public String getCol() {
		return col;
	}

	public void setCol(String col) {
		this.col = col;
	}

	public String getNameorunit() {
		return nameorunit;
	}

	public void setNameorunit(String nameorunit) {
		this.nameorunit = nameorunit;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getAreaprovince() {
		return areaprovince;
	}

	public void setAreaprovince(String areaprovince) {
		this.areaprovince = areaprovince;
	}

	public Integer getMoneyis() {
		return moneyis;
	}

	public void setMoneyis(Integer moneyis) {
		this.moneyis = moneyis;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getQqnumber() {
		return qqnumber;
	}

	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}

	public String getIdcardnumber() {
		return idcardnumber;
	}

	public void setIdcardnumber(String idcardnumber) {
		this.idcardnumber = idcardnumber;
	}

	public String getReportwork() {
		return reportwork;
	}

	public void setReportwork(String reportwork) {
		this.reportwork = reportwork;
	}

	public Integer getReportpolitical() {
		return reportpolitical;
	}

	public void setReportpolitical(Integer reportpolitical) {
		this.reportpolitical = reportpolitical;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getReportertype() {
		return reportertype;
	}

	public void setReportertype(String reportertype) {
		this.reportertype = reportertype;
	}

	public String getReporterdestype() {
		return reporterdestype;
	}

	public void setReporterdestype(String reporterdestype) {
		this.reporterdestype = reporterdestype;
	}

	public String getReporterdesother() {
		return reporterdesother;
	}

	public void setReporterdesother(String reporterdesother) {
		this.reporterdesother = reporterdesother;
	}

	public String getSitetype() {
		return sitetype;
	}

	public void setSitetype(String sitetype) {
		this.sitetype = sitetype;
	}

	public String getSitedestype() {
		return sitedestype;
	}

	public void setSitedestype(String sitedestype) {
		this.sitedestype = sitedestype;
	}

	public Integer getToolname() {
		return toolname;
	}

	public void setToolname(Integer toolname) {
		this.toolname = toolname;
	}

	public Integer getDrivename() {
		return drivename;
	}

	public void setDrivename(Integer drivename) {
		this.drivename = drivename;
	}

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public Integer getAccountnature() {
		return accountnature;
	}

	public void setAccountnature(Integer accountnature) {
		this.accountnature = accountnature;
	}

	public Integer getRewardtype() {
		return rewardtype;
	}

	public void setRewardtype(Integer rewardtype) {
		this.rewardtype = rewardtype;
	}

	public String getRecognitioncode() {
		return recognitioncode;
	}

	public void setRecognitioncode(String recognitioncode) {
		this.recognitioncode = recognitioncode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatuslast() {
		return statuslast;
	}

	public void setStatuslast(Integer statuslast) {
		this.statuslast = statuslast;
	}

	public Date getLatestdate() {
		return latestdate;
	}

	public void setLatestdate(Date latestdate) {
		this.latestdate = latestdate;
	}

	public Integer getRefagencyid() {
		return refagencyid;
	}

	public void setRefagencyid(Integer refagencyid) {
		this.refagencyid = refagencyid;
	}

	public Date getRemovetime() {
		return removetime;
	}

	public void setRemovetime(Date removetime) {
		this.removetime = removetime;
	}

	public Integer getIsmanualwpss() {
		return ismanualwpss;
	}

	public void setIsmanualwpss(Integer ismanualwpss) {
		this.ismanualwpss = ismanualwpss;
	}

	public List<String> getUrllist() {
		return urllist;
	}

	public void setUrllist(List<String> urllist) {
		this.urllist = urllist;
	}

	public Integer getTextnum() {
		return textnum;
	}

	public void setTextnum(Integer textnum) {
		this.textnum = textnum;
	}

	public Integer getPornimgnum() {
		return pornimgnum;
	}

	public void setPornimgnum(Integer pornimgnum) {
		this.pornimgnum = pornimgnum;
	}

	public Integer getAttachpornimg() {
		return attachpornimg;
	}

	public void setAttachpornimg(Integer attachpornimg) {
		this.attachpornimg = attachpornimg;
	}

	public String getProvincecodename() {
		return provincecodename;
	}

	public void setProvincecodename(String provincecodename) {
		this.provincecodename = provincecodename;
	}

	public String getCitycodename() {
		return citycodename;
	}

	public void setCitycodename(String citycodename) {
		this.citycodename = citycodename;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getSocietyname() {
		return societyname;
	}

	public void setSocietyname(String societyname) {
		this.societyname = societyname;
	}

	public String getCatalogname() {
		return catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public String getTypecodename() {
		return typecodename;
	}

	public void setTypecodename(String typecodename) {
		this.typecodename = typecodename;
	}

	public String getWaycodename() {
		return waycodename;
	}

	public void setWaycodename(String waycodename) {
		this.waycodename = waycodename;
	}

	public String getSeidname() {
		return seidname;
	}

	public void setSeidname(String seidname) {
		this.seidname = seidname;
	}

	public String getAreaprovincename() {
		return areaprovincename;
	}

	public void setAreaprovincename(String areaprovincename) {
		this.areaprovincename = areaprovincename;
	}


	public String getCountycode() {
		return countycode;
	}

	public void setCountycode(String countycode) {
		this.countycode = countycode;
	}

	public String getCodeitemid() {
		return codeitemid;
	}

	public void setCodeitemid(String codeitemid) {
		this.codeitemid = codeitemid;
	}

	public Integer getMemsocietyid() {
		return memsocietyid;
	}

	public void setMemsocietyid(Integer memsocietyid) {
		this.memsocietyid = memsocietyid;
	}

	public Integer getCardtype() {
		return cardtype;
	}

	public void setCardtype(Integer cardtype) {
		this.cardtype = cardtype;
	}

	public Date getHappentime() {
		return happentime;
	}

	public void setHappentime(Date happentime) {
		this.happentime = happentime;
	}

	public Integer getIsvictim() {
		return isvictim;
	}

	public void setIsvictim(Integer isvictim) {
		this.isvictim = isvictim;
	}

	public Integer getNetworkservice() {
		return networkservice;
	}

	public void setNetworkservice(Integer networkservice) {
		this.networkservice = networkservice;
	}

	public String getIllegalappname() {
		return illegalappname;
	}

	public void setIllegalappname(String illegalappname) {
		this.illegalappname = illegalappname;
	}

	public String getSuspect_name() {
		return suspect_name;
	}

	public void setSuspect_name(String suspect_name) {
		this.suspect_name = suspect_name;
	}

	public String getSuspect_tel() {
		return suspect_tel;
	}

	public void setSuspect_tel(String suspect_tel) {
		this.suspect_tel = suspect_tel;
	}

	public String getSuspect_email() {
		return suspect_email;
	}

	public void setSuspect_email(String suspect_email) {
		this.suspect_email = suspect_email;
	}

	public Integer getSuspect_paytype_big() {
		return suspect_paytype_big;
	}

	public void setSuspect_paytype_big(Integer suspect_paytype_big) {
		this.suspect_paytype_big = suspect_paytype_big;
	}

	public Integer getSuspect_paytype_smart() {
		return suspect_paytype_smart;
	}

	public void setSuspect_paytype_smart(Integer suspect_paytype_smart) {
		this.suspect_paytype_smart = suspect_paytype_smart;
	}

	public String getSuspect_payaccount() {
		return suspect_payaccount;
	}

	public void setSuspect_payaccount(String suspect_payaccount) {
		this.suspect_payaccount = suspect_payaccount;
	}

	public String getSuspect_sheng() {
		return suspect_sheng;
	}

	public void setSuspect_sheng(String suspect_sheng) {
		this.suspect_sheng = suspect_sheng;
	}

	public String getSuspect_shi() {
		return suspect_shi;
	}

	public void setSuspect_shi(String suspect_shi) {
		this.suspect_shi = suspect_shi;
	}

	public String getVictim_sheng() {
		return victim_sheng;
	}

	public void setVictim_sheng(String victim_sheng) {
		this.victim_sheng = victim_sheng;
	}

	public String getVictim_shi() {
		return victim_shi;
	}

	public void setVictim_shi(String victim_shi) {
		this.victim_shi = victim_shi;
	}

	public String getSuspect_xian() {
		return suspect_xian;
	}

	public void setSuspect_xian(String suspect_xian) {
		this.suspect_xian = suspect_xian;
	}

	public String getVictim_xian() {
		return victim_xian;
	}

	public void setVictim_xian(String victim_xian) {
		this.victim_xian = victim_xian;
	}

	public String getMesonlyid() {
		return mesonlyid;
	}

	public void setMesonlyid(String mesonlyid) {
		this.mesonlyid = mesonlyid;
	}
	
}
