package com.henry.wordpad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class University extends AppCompatActivity {
    Button Btn;
    private ListView Lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        Btn = findViewById(R.id.btn_return_2);
        Lv = findViewById(R.id.Lv);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(University.this, MainActivity.class);
                startActivity(intent);
            }
        });


        final String[] name = new String[]{"金融学院", "保险学院", "证券与期货学院", "经济学院", "工商管理学院", "会计学院", "财税学院", "统计学院", "经济信息工程学院", "法学院", "经贸外语学院", "国际商学院", "公共管理学院", "马克思主义学院", "经济数学学院", "通识教育学院", "国际教育学院", "出国留学预备学院", "继续(网络)教育学院", "西部商学院", "体育学院", "经济与管理研究院", "北京研究院", "中国西部经济研究中心", "社会发展研究院", "中国金融研究中心"};
        final String[] detail = new String[]{
                "　　学科办学历史可追溯到1925年光华大学商科银行学系；1997年在西南财经大学原金融系、国际经济系国际金融教研室以及农经系农村金融教研室的基础上组建金融学院；1998年金融学被评为中国人民银行行属重点学科，金融学专业开始招收博士后；2000年设立教育部人文社会科学重点研究基地--中国金融研究中心；2002年金融学科在教育部组织的评审中综合实力排名全国第一，被评为首批国家重点学科；2007年再次通过教育部全国重点学科评审；“金融学国际化人才培养”项目获批国家级特色专业建设点，并承担“经济管理复合型拔尖创新人才培养模式创新实验区”国家级质量工程项目；2009年承担“第二类特色专业金融国际化人才培养”国家级质量工程项目，《投资学》课程被评为国家级双语示范课程；2010年《货币金融学》教学团队被评为国家级优秀教学团队；2011年，985工程“金融学科群与中国金融创新发展”优势学科创新平台正式立项建设；2012年获批国家级实验教学示范中心——教育部现代金融创新实验教学中心，金融学名列中国大学重点院校2011-2012年国家重点学科硕士研究生教育与科研指标评定及专业排名全国第一；2013年获批国家级实验室——金融虚拟仿真实验室，成为中国大陆首家通过CFA（注册金融分析师）协会创立课程认证计划(CFA University Recognition Program)认证学院,；2015年再获CFA（注册金融分析师）协会合作伙伴(CFA Program Partners)认证。",
                "　　西南财经大学保险学科的办学历史可追溯至1946年重庆大学商学院银行保险系，1952年并入四川财经学院，并于当年开始招收保险干部专科生（1958年~1983年停办）。1983年，经教育部批准，受中国人民保险股份有限公司委托开设保险学专业，并于当年率先在国内成立保险教研室，招收金融学（保险方向）硕士研究生，1984年招收保险学干部专科生，1985年招收保险学专业本科生，1991年保险系单独建制，开始独立招生，1995年招收保险学（国际保险会计方向）硕士研究生，1996年招收金融学（保险方向）博士研究生，1997年成立国内普通高校首家保险学院，2000年开设劳动与社会保障本科专业、获批社会保障专业硕士点，2002年招收社会保障硕士研究生，2003年招收保险学（保险精算方向）硕士研究生，2004年独立设置保险学硕士点和博士点，2005年在本科层次开设保险学（保险精算方向）和保险学（保险财务与会计双语实验班），2006年独立设置社会保险与经济保障专业博士点，2007年在劳动与社会保障专业中招收企业年金方向本科生，2008年在保险学专业中招收风险管理方向本科生，并在保险学（双语实验班）中分别设置保险精算和保险财务与会计方向。2018年获教育部批准建设精算学本科专业。近三十年来，先后培养保险与社会保障专业的干部专科、学士、硕士、博士近6000多人，并与业界紧密合作，先后为保监会、国内各家保险公司培养高层管理干部和业务骨干2万余人，校友遍布全国各大企事业单位。",
                "　　随着资本市场的快速发展，机构、产品不断扩张，2008年9月28日，在西南财经大学党委、行政的领导下，在社会各界的鼎力支持下，国内全日制高等教育唯一培养证券、期货人才的专业性学院----西南财经大学证券与期货学院正式成立。前中国证监会主席周正庆教授任学院首任名誉院长。",
                "　　经济学院办学历史悠久，著名经济学家陈豹隐教授、彭迪先教授、汤象龙教授、刘诗白教授等，为经济学院的发展做了很多开拓和奠基性的工作，在半个多世纪的发展中，先后涌现出一大批的学者和学科带头人，从事教学和科学研究工作。",
                "　　工商管理学院是西南财经大学办学历史最悠久，师资力量最强，办学规模最大的学院之一。学院于1997年由工业经济系、贸易经济系以及国际经济系中的国际贸易专业组建成立。学院办学层次齐全，包括本科、硕士、博士到博士后流动站。",
                "　　西南财经大学会计学院历史悠久。前身会计系始建于1938年，系抗战时期上海光华大学内迁成都时设立，我国第一号注册会计师、著名会计学家谢霖教授曾主持本学科工作。学院是我国首批设置会计学本科专业（1952）、较早获得管理学（会计学）硕士学位授权点（1981）和会计学博士学位授权点（1996）的院校之一，也是全国首批开设会计硕士（MPAcc）专业学位（2004）、资产评估硕士（MV）专业学位（2010）、审计硕士（MAud）专业学位（2013）和设立注册会计师（CPA）专门化专业方向的院校（1994）之一，2014年，学院开设了西南地区第一个MPAcc在职双证高端人才培养项目。目前，我校会计学是国家级重点学科。",
                "　　财政税务学院成立于1991年，是全国最早成立的财政税务专门学院。前身财政系始建于1952年，由当时西南地区17所财经院校和部分综合大学经济系中的财政学专家、学者组成，荟萃了一批知名财政专家，如陈豹隐、李锐、许廷星、左治生、谭本源、张国干、刘邦驰等。财政学专业于1952年开始招收本科生，是全国最早设置的财政学专业之一。财政学科于1983年经国务院学位委员会批准为硕士授权点，1986年获批为博士授权点，1995年被评为省（部）级重点学科。在国家“双一流”建设中，学院财政学科成为西南财经大学应用经济学一流学科建设的重要组成部分。",
                "　　西南财经大学统计学院至今已有60余年的办学历史，是全国财经院校中最早招收统计学本科生的单位之一，是西部地区最早的统计学、数量经济学博士点，也是西部地区最早的统计学博士后流动站。学院拥有国家级重点学科、国家级特色专业、国家级精品课程、国家级教学名师、国家优秀教学团队、全国优秀教师、全国师德先进集体、新世纪优秀人才等殊荣，已成为我国统计学、数量经济学、管理科学与工程、数据科学与大数据技术人才培养和科学研究的一个重要基地。 ",
                "　　经济信息工程学院的前身是成立于1985年的经济信息管理系，2001年11月更名为西南财经大学经济信息工程学院。长期以来，学院坚持社会主义办学方向，落实立德树人根本任务，秉承学校“经世济民、孜孜以求”的大学精神和学院“理工固本、财经铸魂”的办学理念，充分依托学校经济学、管理学学科优势，形成了融工学、经济学、管理学为一体、本硕博（博士后）办学层次完整的办学实体。在“互联网+”时代背景下，学院瞄准人工智能和金融科技发展前沿，以金融智能和区块链为主要发展方向，深入推动以现代信息技术为核心的多学科交叉融合，全面实施“现代信息技术+”学科发展战略，不断提升科技成果转化能力，不断创新人才培养模式，致力于培养掌握大数据处理能力、金融信息挖掘能力、智能管理决策能力、适应未来激烈竞争的具有社会责任感、创新精神和国际视野的财经领域复合型卓越人才，着力将学院建设成财经特色鲜明、在国内具有显著影响力的一流信息学院。",
                "　　西南财经大学法学院的历史，可上溯至1925年光华大学的法学教育。1946年在光华大学成都分校基础上成立的成华大学按光华大学院系组织办学。20世纪40年代成立的正阳法商学院、相辉文法学院作为西南财经大学仅有的两所法科前身学校，为光华法学的发展积淀了深厚底蕴。涌现了诸如“中国近代法律教育的奠基人” 之一、著名的法学家、社会活动家、文化名人的江庸教授、被誉为“中国宪政理论先驱”的萧公权教授、“中华民国宪法之父”的张君劢教授、因翻译《社会法理学论略》而为中国法理学发展作出巨大贡献的陆鼎揆教授、在国际上享有较高声望并被聘为瑞士国际法庭刑法顾问的夏勤院长等一大批著名的法学家、教育家和社会活动家，为中国近代培养了大批的法律人才，为中国近代法制建设的奠基做出了巨大贡献。",
                "　　1994年成立经贸外语系并招收“英语专业（经贸英语方向）”本科生。2001年，经贸外语系和原汉语教研室合并成立语言文化学院。2007年原语言文化学院的汉语专业师生整体转入人文学院，学院更名为西南财经大学经贸外语学院。",
                "　　学校整合相关专业于1996年设立国际商学院。秉承老一辈著名经济学者严谨的治学精神，国际商学院与时俱进，稳步发展。目前，学院拥有国际经济与贸易（双语实验班）、国际商务（双语实验班）、国际商务（中外合作办学）三个本科专业；国际经济与贸易、国际商务两个科学硕士和博士专业、一个国际商务专业硕士专业。目前学院设有2个系12个研究中心（所）和1个实践教育指导中心，包括国际经济与贸易系、国际商务系、国际贸易研究所，国际商务研究所、四川省“内陆地区对外直接投资创新发展”协同创新中心，西南财经大学中国（四川）自由贸易试验区综合研究院，中东欧与巴尔干地区研究中心，“一带一路”与全球治理研究中心，地缘经济与政治研究所，中英FDI研究所，国际服务外包研究所，全球化与管理研究所，国际商务硕士（MIB）教育中心、汉语背景下专业课程英语（ESP）教学与研究中心、大学生实践教育指导中心。",
                "　　时代呼唤公共管理，时代更需要公共管理。西南财经大学以战略的眼光，适应社会发展的迫切需要，在学校原政治系基础上，整合本校经济学、管理学等相关学科资源，于2001年成立了公共管理学院。我校是全国最早成立公共管理学院的高校之一。 \n" +
                        "　　十余年来，我们秉持“经世济民，孜孜以求”的西财精神，遵循“入主流、办特色、做交叉”的办学理念，实施“学术立院、人才强院、民主治院”的建院思路，恪守“人格独立、严谨宽容、追求公平、责任至上”的院训，积极探索“以经济学为背景的公共管理学科”发展之路，学院已经建设成为西部有影响力的、全国重要的公共管理人才培养基地和科学研究及社会服务基地。\n" +
                        "　　学院拥有公共管理一级学科、劳动经济学和人力资源管理两个二级学科，下设行政管理系、人力资源管理系、劳动经济研究所、公共经济研究所等。学院建有四川省哲学社会科学重点研究基地“公共政策创新研究中心”、西南财经大学地方政府治理研究中心、西南财经大学社会风险与危机管理研究中心、西南财经大学健康政策与治理研究中心、西南财大公共服务与绩效评估协同研究中心等研究机构。学院拥有行政管理、人力资源管理两个本科专业；行政管理、社会医学与卫生事业管理、政策科学与公共管理创新、公共经济、人力资源管理、劳动经济学六个硕士学位授权点及公共管理硕士（MPA）专业学位授权点；政策科学与公共管理创新、劳动经济学、公共经济制度与政策三个博士学位授权点，并形成了“以经济学为背景，培养复合型、应用型高级公共管理人才”的人才培养特色。其中，我院人力资源本科专业和行政管理本科专业在武汉大学中国科学评价研究中心（RCCSE）和中国科教评价网（www.nseac.com）联合发布《中国大学及学科专业评估报告》中分别名列全国第2名（2010年）、第15名（2012年）。",
                "　　西南财经大学马克思主义理论学科和思想政治理论教育具有悠久而光荣的历史。1952年—1990年，学校的思想政治理论教育由校内两个相对独立的教学单位共同承担，即马列主义教研室（部）和德育教研室（部），其中马列主义教研室（部）主要负责马克思主义基本理论教育，德育教育研究主要负责思想品德、法律知识、形势政策方面的教育。1991年—2001年，伴随着我国改革开放和高等教育飞速发展的步伐，按照我校向多科型大学发展的战略思路，两室（部）中的马列主义教研部更名为西南财经大学政治系。政治系除继续承担全校各层次学生的马克思主义基本理论教育外，还相继开设了“思想政治教育”、“人力资源管理”、“公共事业管理”等本科专业。随着我校由单科型大学转型为多科型大学，特别是面对因高等教育大发展对加强大学生思想政治教育的更高要求，2001年11月，学校党委决定将政治系中部分马克思主义理论教育骨干师资与德育教研室合并，成立“马克思主义理论与思想政治教育教学研究中心”（简称“两课”中心），作为本校负责思想政治理论教育的专门教学科研机构。2004年6月，“两课”中心更名为马克思主义学院。",
                "　　西南财经大学经济数学学院始于2002年成立的经济数学系，2007年更名为经济数学学院。学院坚持“数学为本、数经融合、特色发展”的办学理念，经过17年的不懈努力，学院拥有了金融数学从本科到硕士、博士完整的培养体系，并拥有数理金融学博士后流动站，金融数学特色凸显，综合办学实力显著提高。",
                "　　人文（通识）学院是适应我校加强学科建设、完善学科专业结构和通识教育改革需要于2007年初组建的充满浓郁光华财经文化底蕴的学院。学院秉承“经世济民、孜孜以求”的西南财大精神，以“授蒙养正、博雅信达”为教育理念；学院以学校半个多世纪的发展积淀为基础，整合了学校自2002年以来开办的汉语言文学、新闻学、社会工作三个本科专业及相关学院部分教师资源，同时，引进了一批国内外师资，形成了一支专兼职结合，学缘结构合理，学历层次较高的年青化的教师队伍。目前，专职教师37人，其中教授5人、副教授9人，讲师18人，其中，博士毕业生15人。中青年教师中具有博士、硕士学位的教师比例达到100%。另外聘有海内外兼职教授5人、副教授2人。此外，学院还拥有一支近二十人的专职行政教学管理队伍和专兼结合的辅导员队伍。",
                "　　西南财经大学从1996年开始招收留学生，于2004年成立国际教育学院。国际教育学院全面负责学校的来华留学生教育和中外合作办学事务。在来华留学生教育方面，已累计招收了来自美国、法国、德国、菲律宾、土尔其、澳大利亚、蒙古、韩国、英国、日本、加拿大、以色列、俄罗斯、泰国、爱尔兰等上百个国家数千名留学生来校学习汉语和专业课程，并建立和健全了从本、硕、博的中文授课及全英文授课的培养体系，形成了涵盖语言进修生、中文及全英文授课的多层次留学生培养模式。国际教育学院拥有完善的教学和生活设施、优良的管理和服务经验，优秀的师资队伍，愿意且能够为广大的海外留学生提供优质的教育与服务",
                "　　西南财经大学出国预备学院（Study Abroad Institute以下简称SAI）是西南地区首家由中国（教育部）留学服务中心指定的国家级出国留学培训基地，是中国（教育部）留学服务中心在全国设立共建的基地中专门对接国外大学经济学、金融学、金融工程学、会计学、管理信息系统科学、市场营销学、创业学、领导科学、国际贸易、物流管理学、酒店管理等专业的留学培训基地。SAI作为西南财经大学国际化战略平台和培养高层次国际化经济管理人才的“孵化器”，肩负着造就能参与国际事务、具有国际视野、通晓国际规则的经济管理高端人才的社会责任和历史使命。",
                "　　九秩西财，弥久历新。西南财经大学继续教育根植沃土、胼手胝足，筚路蓝缕、弦歌不辍，承载着悠久的历史和光荣的传统。建国初始，百废待兴，职业教育，应时而生，学校由业余教育处负责举办工农夜校、干部进修班等培养和培训急需的经济管理人才。1964年成立函授部，1978年开办各类业务培训和干部专修科。1982年，被确定为四川省经济类专业高等教育自学考试主考学校，1986年成立自学考试办公室。1986年成立成人教育处，1997年，在原成人教育处的基础上组建成人教育学院。2002年，被教育部批准开展现代远程教育试点，成立网络教育学院，承担成人高等学历教育现代远程教育试点工作。2008年成立西南财经大学培训中心。2013年成人教育学院和网络教育学院更名为继续（网络）教育学院。",
                "　　西部商学院从2007年筹划到2014年正式成立经历了近8年的时间，原高管中心及EMBA项目整体划入，这对财大具有巨大的意义。学校在光华校区投资600多万装修了3个全新的国际标准教室供西部商学院使用。学院采用理事会领导下的院长负责制，邀请世界知名人士担任西部商学院理事会成员，由西南财经大学副校长杨丹亲自担任西部商学院院长一职。西商之于西财就好像保时捷之于大众，是西南财经大学着力打造的一个中西部地区的顶尖商学院。 办学理念：西南财经大学西部商学院以“创业导向，独具特色，世界一流”为办学理念坚持“带着问题来，拿着答案走”的培养方式，以提升学员的判断能力、决策能力、创新能力和社会责任力为目标",
                "　　1995年体育教研室从学校基础部中独立出来成立体育教学研究部；2015年根据《西南财经大学章程》有关规定，结合学校事业发展需要，更名为体育学院。二十多年来，在学校党委的领导下，西南财经大学体育学院秉承优良的治学传统，以增进大学生体质健康和满足大学生日益增长的体育文化需求为主线，立足大学体育，本着“以人为本、健康第一、强身健体、经世济民”的指导思想，以健康体育、快乐体育、终身体育为理念，通过多种体育教学形式和途径，增强学生体质、锻炼学生体魄，促进学生身心素质全面协调发展，为培养“经世济民”的高素质财经人才提供人力资本中最基础的体质健康保障，在学校全面推进素质教育中发挥着重要的作用。",
                "　　西南财经大学经济与管理研究院是西南财大为适应国际化发展趋势，改革经济学与管理学人才培养模式、转换科学研究范式，于2006 年新成立的专门吸收海外经济、金融与管理领域的博士毕业生和研究人员的教学、研究机构。我们的目标是努力创立一个国内一流、国际知名的经济与管理研究中心，成为祖国西部地区乃至全国的重要思想库和智囊中心。",
                "　　北京研究院是根据学校战略部署于2013年6月正式成立的集科研信息搜集、科学研究服务、科研成果推介、学术资源整合和高端人才培养功能为一体的创新型研究机构，系学校内设、异地（北京）办公的二级单位。",
                "　　中国西部经济研究中心是西南财经大学响应国家西部大开发战略，充分发挥综合性财经学科优势，为地方经济建设服务组建成立的教学科研单位。设有人口研究所、农村改革与发展研究所、农业硕士教育与发展研究所三个教学科研机构。现有教职工35人，其中科研和教学人员27人，博士生导师7人，教授（研究员）9人，副教授（副研究员）13人，讲师5人。另外，还聘请多位知名专家学者为兼职博士生导师。",
                "　　西南财经大学社会发展研究院成立于2017年3月，前身是社会工作发展研究中心（成立于2007年10月），是首批国家社会工作人才培训基地，同时也是四川省首批社会工作人才培训基地。宗旨是整合我校社会经济学、社会工作、社会学、社会保障、公共管理、人口学等相关学科师资力量，邀请国内外大专院校、科研院所和知名社工实务机构的知名专家学者，共同研究中国经济社会尤其是社会工作发展面临的重大理论和实践问题，为我国社会建设和社会创新贡献自己的力量。",
                "　　西南财经大学中国金融研究中心（以下简称中心）是按照教育部《普通高等学校人文社会科学重点基地建设计划》组建，2000年9月被正式列为教育部人文社会科学百所重点研究基地之一。中心名誉主任为曾康霖教授、刘锡良教授，现任主任为王擎教授，党总支书记为李大勇，副主任为董青马副教授、王鹏教授。",
        };
        final int[] picture = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4,R.drawable.p5,R.drawable.p6, R.drawable.p7, R.drawable.p8,R.drawable.p9, R.drawable.p10, R.drawable.p11, R.drawable.p12,R.drawable.p13, R.drawable.p14, R.drawable.p15, R.drawable.p16,R.drawable.p17, R.drawable.p18, R.drawable.p19, R.drawable.p20,R.drawable.p21, R.drawable.p22, R.drawable.p23, R.drawable.p24,R.drawable.p25, R.drawable.p26};
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("picture", R.drawable.p1);
        map1.put("name", name[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("picture", R.drawable.p2);
        map2.put("name", name[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("picture", R.drawable.p3);
        map3.put("name", name[2]);
        data.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("picture", R.drawable.p4);
        map4.put("name", name[3]);
        data.add(map4);

        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("picture", R.drawable.p5);
        map5.put("name", name[4]);
        data.add(map5);

        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("picture", R.drawable.p6);
        map6.put("name", name[5]);
        data.add(map6);

        Map<String, Object> map7 = new HashMap<String, Object>();
        map7.put("picture", R.drawable.p7);
        map7.put("name", name[6]);
        data.add(map7);

        Map<String, Object> map8 = new HashMap<String, Object>();
        map8.put("picture", R.drawable.p8);
        map8.put("name", name[7]);
        data.add(map8);

        Map<String, Object> map9 = new HashMap<String, Object>();
        map9.put("picture", R.drawable.p9);
        map9.put("name", name[8]);
        data.add(map9);

        Map<String, Object> map10 = new HashMap<String, Object>();
        map10.put("picture", R.drawable.p10);
        map10.put("name", name[9]);
        data.add(map10);

        Map<String, Object> map11 = new HashMap<String, Object>();
        map11.put("picture", R.drawable.p11);
        map11.put("name", name[10]);
        data.add(map11);

        Map<String, Object> map12 = new HashMap<String, Object>();
        map12.put("picture", R.drawable.p12);
        map12.put("name", name[11]);
        data.add(map12);

        Map<String, Object> map13 = new HashMap<String, Object>();
        map13.put("picture", R.drawable.p13);
        map13.put("name", name[12]);
        data.add(map13);

        Map<String, Object> map14 = new HashMap<String, Object>();
        map14.put("picture", R.drawable.p14);
        map14.put("name", name[13]);
        data.add(map14);

        Map<String, Object> map15 = new HashMap<String, Object>();
        map15.put("picture", R.drawable.p15);
        map15.put("name", name[14]);
        data.add(map15);

        Map<String, Object> map16 = new HashMap<String, Object>();
        map16.put("picture", R.drawable.p16);
        map16.put("name", name[15]);
        data.add(map16);

        Map<String, Object> map17 = new HashMap<String, Object>();
        map17.put("picture", R.drawable.p17);
        map17.put("name", name[16]);
        data.add(map17);

        Map<String, Object> map18 = new HashMap<String, Object>();
        map18.put("picture", R.drawable.p18);
        map18.put("name", name[17]);
        data.add(map18);

        Map<String, Object> map19 = new HashMap<String, Object>();
        map19.put("picture", R.drawable.p19);
        map19.put("name", name[18]);
        data.add(map19);

        Map<String, Object> map20 = new HashMap<String, Object>();
        map20.put("picture", R.drawable.p20);
        map20.put("name", name[19]);
        data.add(map20);

        Map<String, Object> map21 = new HashMap<String, Object>();
        map21.put("picture", R.drawable.p21);
        map21.put("name", name[20]);
        data.add(map21);

        Map<String, Object> map22 = new HashMap<String, Object>();
        map22.put("picture", R.drawable.p22);
        map22.put("name", name[21]);
        data.add(map22);

        Map<String, Object> map23 = new HashMap<String, Object>();
        map23.put("picture", R.drawable.p23);
        map23.put("name", name[22]);
        data.add(map23);

        Map<String, Object> map24 = new HashMap<String, Object>();
        map24.put("picture", R.drawable.p24);
        map24.put("name", name[23]);
        data.add(map24);

        Map<String, Object> map25 = new HashMap<String, Object>();
        map25.put("picture", R.drawable.p25);
        map25.put("name", name[24]);
        data.add(map25);

        Map<String, Object> map26 = new HashMap<String, Object>();
        map26.put("picture", R.drawable.p26);
        map26.put("name", name[25]);
        data.add(map26);



        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.list_item, new String[]{"picture", "name"}, new int[]{R.id.iv, R.id.tv_name}));
        Lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("picture", picture[arg2]);
                bundle.putString("detail", detail[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(University.this, com.henry.wordpad.ListChange.class);
                Log.i("detail", detail[arg2]);
                startActivity(intent);
            }
        });
    }

}

