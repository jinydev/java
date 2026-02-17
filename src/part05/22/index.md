---
layout: part05
title: Chapter 22. 부록 (Appendix)
---

# Chapter 22. 부록 (Appendix)

> **WARNING**: This content was generated via OCR from a source PDF with severe font encoding issues. Text quality may be degraded. An archive of the original high-quality conversion is available in `src/22/index_backup.md`.

Appendix        0 ]

데이터베이스 입출력
(MySQL8)

ㅠ

201 ec 7a
202 DBMS a8]
203 Clot Too 시지
24 매구보

ons 08 ea

208 DIE Ae
207 Ole 48
208 let at
209 Ale $11
2010 SR Hel
ass AN PEE

besos wet
ome 7A


20.1 JDBC 개요

sat AP
‘ee SRA NBR He 게스 티스트 FH 있다

ㅣ                        oe HA                        ㅣ

JDBC 인터페이스를 FH AME DBA 작업하는 것은 JDBC 101400이다. JDBC Driver

 1080에 SERS} 있는 SsbA} eae) a He ASAE 같다,

Bc vas 7)

2 Appendix

DriverManager
DriverManager #

스는 JDBC Drivers #ele}o| DBS} e244] Connection 구현 43%

Connection
Connecion t8+1 Sutemen, PreparedSutement,Callbestatement 구형 A
AA Settee ed DB AER AB

Statement

ssatement 661%
atic, 주로 Ws 않는 정적 SOL ALN LAN
ProparedStatoment

Prepardstatement Statement} $84 SQL DDL, DML EE AR MHEG, 차
o1RE orth SOL ANB 수 있기 때문에 eels 보안성의 eh, tae Statement
edhe PeparedSutements #5488,

CallableStatement

ResultSet
Resultser® DBTM 7742 데이터를 이음 때 HD

기 ams wo ue

S200,

‘Se DIED. HRM SOLS) POF CAS et CL

머9이이스04604 3

20.2 DBMS 설치

을 기준으로 eet

MySQL 설치
원도우 운영제제여서 MySQL Aaa 보자.

1 MySQL 설치 파일은 다음 10에 BRA HORE + 있다,

02 [Download] ER fe mysq-insallerweb-communiy-8.0.25.0. 18 다
SEEN, RRA] 전에 로그인 ol 뜨는. Se A dH) AI No thanks just
seat my download 928 B92 BO,


03                                                               choosing

Setup Type 단계에서 Installer} 제공하는 SW AlHALe 설치하기 #8 Custom’ 선태
WE Next] MER sett,

(04, Select Prodects Uo] Avallable Products 52} MySQL Server 8.0.25, 36690.
Workbench 80,25, Connector} 80,25'% ARI SHI 놀러 28] Products To
Be Installed $532. 추가시키고 Neat] WEG Beit,

Or eewois aeasoLs) 5

Products

yal Serer 025 —x84           | pes
1804 Wontere a25 Wee        | be sera a i Toa
Cored a025 906            | 00009

8 Append

07 DBMS 성정을 Hel Production
Configuration #14 [Neat] HER 글리
빠

08 Type and Networking esta
MySQL 서버 구성 타임 LUMA a a
을 정한다 RB PCA AIS Contig
‘Type#2 Development Computer's 선
BL, 0000004500에서는 TOPPA
그박스에 Masia Pont 330022 심정
깐다, 나머지는 모두 기본 A ade 두고
10400 바튼 Bee

109 Authencton Method Stee 71

을 ete

oF sewois aeonsaL

7

10 Accounts and Roles 단계에서는 관리자 AI Roor®| VIE mysql Ie
그리고 사용자 PAG 추가하기 위해 [Add User] WHER 클릭하고, User Nameot java

"
WA 자동 실행될 수 있도록 기본 ee 그대
로 두고 New! MER FCG,

12 Apply Configuration eee: 설치 시 섬정해야 할 목독음 Wo} 준다 [Execute] MER
-gelota Ao] Be Finish] EG zeke,


13
“8 elehe 설치 과정을 모두 마치게 된다.

oF eos

02 N QBS 3A ORAPICIBA 감미 NSN 모트톨선틱히교10481브을 SEL
OPER eae mane 8
SS

0 Tor ein, a) 2 me BN oO SME a MES aS

04 asi eg ania Sachs] asec,

Osserenae,
FUER enc cree ascencarnoeene

0s THI gate Avie 2s asl gaia S(T HES OL

OBR ansanes eon ene ae enc

‘opendi

05 791 016 인 %60Ｌ이리고이. OIE we

20.3 Client Tool 설치

MySQL Workbench’= DB 개방 및 elo AMGH= Client Tool MySQL 설치 과정에서
같이 Anis 때문에 추가로 AIG art 없다. APT ase ago Als, to
{elt [MySQU] - IMySQL Workbench xx CEs Aste A) He 된다

Welcome to MySQL Workbench

0506 설치                1
ole 접속 Wie 알아보지. \00050008에서 MySQL Connections 바로 $1 아이
큰음 글릭한다.                                    st gel                        #

oF emote aesous) 1

“Soman a: in
+ Usemame: java’

ea

* Gor Peano romero SHEP: 04204

오른쪽 화면과 ao] 연점 정보 Meh Ae 마우스로 Bet

2 Append

20.4 DB 구성
이제 Woskbenchol" Hr DBS Tables M984 보자,

DB 생성

01 mysQLeta: Dag Avie Imebt 부르
28, Navigator
S18 Schema AEE 전화한 다음 08 생성
을 위해 OTA @ ole Bele

(02 Name glee thisgava'eat 입력하고. Charset(CllaionelA] ECHE MES Bee
자자 3 general 으로 번정한 다음 Apply] HER BIC

ayant,

oF eos

04 성궁적으로 DBP} Aste Navigator 부여

샌성된다 thisisavass
ASSL 마우스 오른쪽 HER ele [Set as
Deiat Schema} Ae java 7042 기분
스키마로 Abate,

Table 생성
on
AE SS SAI Workbench®| Query HAVI4 Hel 넣는다, 그리고 OMS BE BES
ASE 다음 AS 위해 번개 모양 아이콘 83 을 Bele,

02                               페이블 생성하기                                       과
일의 테스트 UES SHAH Workbench®l Query 편집기에 붙여 넣는다. 그리고 PAR BE
BES 선택한 다음 VEG 위배 WA 모양 아이콘(8)음 Ba,

Appendix

03 계좌 8207 A accounts 42188 생성하기 위해 AA 5910005943000005.591
319] AH UES AIH \00450005의 Query 편집기에 Mol 놓는다. elt create al

에서                    보
여야 teh, it 보이지 않는다면 $5 Ato 아이콘(8)을클
al 5-8 AAA,

oF eos


20.5 DB 연결

‘Ballets ee De estes 해당 DBMSA| JDBC Dever? AAI, 또한 연정
에 MEAS 네가지 A Bolo 한다,

setae a                            osc

0 0EMS7 SNE REI 주스
(2 DBMS sigaHe BEPon) we
.2지10891 ae
Ageia D8 08

DaMst oa
개의 paw 관리하므로 실제로 사용함 DB 이미 Basho, 어떤 사용자인지 인중받기 위한 계정
vga waste,

JDBC Driver #81
20.2241 로컬 PCA MySQL AIAN 다음 정로에서 JDBC Driver EN 38 + 있다,

18 Appendix

다운로드합수있다
111051700000509101789061709670901-00000010-7212.

위                                                       는데 MySQL                     마
alo} wait 8.0.8 Woh 보자, 다음 eat go] 버전 ate Sele,
2

10200 nyse wien CHB Aw ea EL

fe 2 ete,

oF eewots ae4soLs) 17

2 PCH SSR ALF URLS] eh mysql-connector~
fnva-80xar MAG thisojava Re 4 ol 복사
잔다 10 BOT 없으면 thse REM OPA OE
‘AES. leh New] - Polder} A 80
그리고 JAR 과일 el 있는 ALA 71 위해 148 과입을 A 후 마우스 2 MER 글
‘te cheat 같이 Build Pathe $7,

© payee CLASSPATH JAR na 3 211

28 274 WC CAB ete CLASSPATH asm 4717
1. Crogan Fieri 21 2012 20122 xls CARR ECL

ect

3 Skye CLASSPATo| cgatgo1/AR mR 2H NaC
($2431 go O71 RIA OB)

18 Aopen

DB 연결
클라이언트
SAE 것이다. Clas forNamel) MAES BAS 주어진 1086. Driver FAAL 8044.
Pathol’ 찾고 steele 2ehe

Cass fran conaysal ci ibe Driver

의 과정에서 DBC Dever F122 66446 tH] 실행되면서 Deiverdanagersl JDBC
Driver 적제를 등록하게 된다. 만약 Build Pathe] JDBC Driver BAG 찾지 못하면:
'04444000040066000800이발생하므로 예의 Aah 해야 한다.

DriverManagerel JDBC Driver?} $4481 etConnection() WEES DBS CAG 함수
os

nection coon = Driveranaper getComection a S249", “BHF, “ue:

 첫 번째 irks al BAIA, DBMSOICY HE AR 가지고 있다, CHEE MySQL] 연접
Bag 보의 준다

|dbe:mysqlsMocalhost:3906/hisisjava

PR 때 | 008

localhost £26 A118 Mysqual @H6}ack: 의미이다, 원적 mysquel tte 1p 주
소로 71 flo} 한다, 33068 Pom 번호, shisgjavat= DB

‘91 Bele getConnection ) AEE Connection A elec, ek wee] alah
‘a SQLExceptions| wage} 예외 afi 해아 한다.

OF eewois ae4soL8) 19

'다음은 20-4014) AR ahisiava DBL ASHE MAG 보이 준다.

package chad mys sect;

1
2
2
4
두 import jva sal sOLexception:
6
7
n
°

ric ca 00060
bic static void sn a) (
on
wt
"         10080 Driver 69
2          ‘las forts on. ysl se Drivers
2
4         ea
6        ‘orn = Driverinager gtComection,
6             “ecm: oclhast336rthisisiva,
7              "
8          wal"
»         »
a»
2
Py
2
2»
5
2%
7
고
»
»
x
2          1 cate SaLexception ©) 1
2         ’
※ 1
Bo
%

20 Appendix

uae
메케

선전 88a DBE BE Hote Connection 재의 close() MAE BALE, 이 대
SQLException) WH 수 있으므로 에의 Ph Bae,

20.6 데이터 저장

이번 eis JDBCEE 이용래서 INSERT 문을 AH WG MOREA, users ole 새로
$489) BMG ABS INSERT 문은 cheat 같다.

SET 7170 users seri      5 wserpassord, useage wrens)
UES Cntr, “ME, “2 25. “vnerameony cor)

a8 708 830.2 AAG AIS INSERT Boe ele 다음과 eh

SUT no wars (er erat, ers. wre, weet
WALES 7, 7,7

그리고 INSERT £8 Sting 타임 변수 sol 문자열로 ae

String sal = now Stringbilder’)
INSERT MT wes 10501. warn, 01005. 01001. seen)“
pend VES (7,7, 7,7, 77)
‘String

때
String sal =

INSERT 7170 users (seri, usernne,wserpassrord,useroge,ustrawail)* +
MES 0.20222

oF eewois gests) 21

Sp AESIE SOL ES Asie Preparedsttemenv} WABI, 다음과 같이 Connection
의 prepareStatement() A=} PreparedStatement Ch,

PrepredStatenent pst = com preparestatenont sal

그리고 71 Bolt WS AGMA, 2 ead 따라 1번부터 번호가 부여된다. 값의 Ho of
가 50004 AES ASML 3 Mote ? 순번, 두 번째에는 aha 지정해 준다.

10059 “winter

pet eg, atc ot

의 fo] 저장된다. execuctipdate() SET AILS gk 저장된 HIM, BIOS 심령
ate 39-18 ete

int rors = pate escitlnsotet

Preparedstatementt © 이상 사용하지 Sh Ae close() MAE BRM
Preparedsatemen7} AB zal abe

 다음 ad users otto 사용자 use Aah Aa SLA Mol 준다,

2 Appendix

See eee Ee ENR

peck

009 cha. mya ec

개다 jva sal SOLException:

aca

eas Weiser (
od minting! ara) {
einen
wt

1000 river
seh at) cre

eae

corn = Dei         -getComecion
cms oclhas:396rthisisina,
ia"

waa 561 2 시
String Sal = = +

INSERT INTO users (seri, vserrane,userassord, 90005
‘seremil) “|
UES 1. 7.7.7. 25

irra 기 2
= Com preparestateentisal):

14. 25:
stm setStringS,-vinterencorpany.cor:

sa 8 에
Ant rows = pst enecutepste:
Syste ut printin¢aea 8 수 "0

2

2
»       Lreparesstaanant 22

a       stn. cose0
서 0 1 atch (Casstotrounception 이 (
2       fe printstackroce
43 Fateh (alexception 2) 1
기       따이
세 이 1900
“6       00000
            re 371
”          “arn cos
se          1 cate SaLException ©) 1
5       ’

2 4
90)
1
mae 비쉬

leet boards ohio AIRE ise) Pe 보자, 새로운 A A Aah INSERT
SEUSS 같다 600는자동 중가 Pel Fe, now’ He Wd ALM

‘To bods (tite, bcantnt,bwriter, bbe, bfilenane, biedat)
WLS Ce SEW PHOT MELE, winter, row), sro. inaryata!

now ()$ Meat USHA 22 ate mA INSERT 문으로 HES, sting 타임 변수
soll 78

과 Appendix

깨가변수화된 INSERT 문을 AGRI #4 CHE ol preparestatement() MAE BIS}
1000704000560400000를업는데, ola 24 두번째 sige 있다,

PraparedStatenant pst = com preparestatenontsl
Staanen RETR SENRATED XS)

‘S01 실회기 APPA 600 E71 때문에 SOL HO] AIF 후에 bao VA VAS 자장
ae owe 것이다.

이제 ?에 해당하는 값을 APKC, 66104 22 바이너리 eI blob) ole ?에값을 지정
하려면 setBinarySiream(),setBlob(), setBytes() 메소드 OHH 이용라야 한다. HE
.500008을 이용혜서 바이트 입력 AEG ABE 짓이다,

pst setStrig(, “2 기:
pst setString2, “Bol Hee."
met sine, itr,
Pe aia
tate, rer FerwStremnsrckhnysl seo)

INSERT £6 실랭하고 저장된 600 2h 얻는 PE Bal 같다, AH 정보가 저장되었음 정
.우005가 19) AF) getGeneratedKeys() MAES 4690500음 얻고, getInt() MER
Daog Seth, Resulstel 대해서는 20,9244 자세히 Ac,

Int on «poeta              isa 은
rant = ptt trees; ine Sec (to 188!
20 708
‘ters raxt 1                       eo 390
int bro = rs.getintt): noe String) ( to" 81 3 MBA bo BAL UE
recone:             18095 HME 1221 4
,

OF emis ae4soLR) 25

HE boards doled me} AEE Ae 전체 BEL,

package champs sect

nore joao Filelypststran:

해다
너

개 ㅣ. public class 30재70000

건. 1 sate wd onto) 1

19 "Cansction coon = nally

4 wt

6         7080 Driver

6          Clas fren Biv:

7

8       ea

1”        ‘orn = Driverinager gtComection,

과             “ecm: oclhast336rthisisiva,

a         “jae

2         wal"

2        1

2»

B         90192 st = 9

2%       String sal =~

a      가리 19096 title, bcontet, titer bate, bflenme,

sedate) "+
Mins 바기 21%

praparecStatonent 221 및 가 A

stn ststring@ winter)

28 Appendix

*         stn setstring, “sow
a       Pr a8 ere srl 6
”

”         로

a            rors =               1901:

“        Senate ABE 변사
a

a         eo & 221

a        해어 에기

5         ResultSet rs 기 pst getGonerateteys):
«             해여깨제11

o            int tro = rs getintt:

a              Systonovt.println A bro: + bol
”          1

a          scores

st         ’

2

a           orostateent £21

더        pein cowes

%          teh ception ©)

*           Ss printSeackrace)

57) finally (

a        fon |= pall) (

벼          [때

a          ree a1

ro            ‘arn close

a          1 catch SolException 6) 1)

a         ’

oe 4

6

«

eae

wet
Dal tna: 1 (AME AGL etre ES 8)

oF sewois aeonsaL

a

20.7 데이터 수정

ARIS BMH OHA,
81 ANE 중에서 boot 3인 AINE bude, beontent, blename, biledatatt WASh=
SQL BE cheat tet

is Ser

suring 타임 변수 sqlol rteishe UPDATE Be 자장한다,

Stig 3 pe Sine)
PONTE

09009 SET"

SAR UPDATE 문을 실황하기 HH 다음과 | preparestatement() ML" ZA}
Preparedstatement 21, > 래당하는 zh APB

개 Appendix

5 stat = 01095):
eat

ves 26 Jen:

pst setString.
pete ele non FelrtSteon cc h20ma/ Secon
pst stint. 3

4
BaOe Aeele 438 el 수가 eee, 만약 oo) teste aed 맞는 ol 없어 수정된
81 SEB Ite

nt rows = pnt oxecotalpdstel

‘fet el boards Holot I We 알맞게 420} 한다.

package chat sal sect

tert jo dofitehoaro:

PrapareStateen
개다 jva sal StLException:
9 public class Boordndatebsanle
0" piblic st ee ts mint 00 1
개 ㅣ 때 coon = nul:

wi

1am briver 64
«           lass frkant onsale Driver":
6

6         eae,

”         ‘oon = Driverinaper getConection

oF ebewois ae4soLs) 20

Se

BaEee

seeesese

‘opendi

“thcmysl-//ocohart 6/thisisin,

wal"

imeranea sa.

17050:

Lerwcstent © X22
Staterant pete = conn prparetatenent a:
ewes es
st setString@, “ee 2 ar:
stn ststring@.
sso stan Filtre skys eH som

peo aete, 35 mts MO Se ees) 8
im 2 a
= pstmt enectetpdatet

Sent rina sa W 수: ros:

iPreparessttanent 27

1 cate Exception ©) 1
‘eprintStackrace
110 (
00000
i

jie 0

20.8 데이터 삭제
이번 Hee JDBC oH DELETE HA AIRE: WHEE oH, boards Hota
bwter"twintert] 모든 88 Abs DELETE 문은 Chest 같다

DELETE FROM boards WHEE beriter= winter”
22291 값을 7 opt apse DELETE Boe 번정한다.

DELETE FROM bards MRE beriter=?
SRI DELETE 8 suing 타임 변수 sqe tee,

String sol = “DELETE FON boards WERE 바하마
ANSI DELETE 문을 실황하기 위해 preparestarement() 메소드로부터
Preparedstatementt? 22 6 8 지정한 후, 040000010700로 SQL 문을 AC eet
ate Abe 4910

String sol = “DELETE FON boards ERE bari
PraparedStatenet pst = com preparestateentsa
pete stString, “inter

nt rows = pstmt executalpte

oF eewois gests) 회

Hee boards doled 저장된 게시품정보름 삭제하는 전체 oI,

0000 champs sect:
2

2

4

5

¢ tit Jneaalancotion

7

의: piblic class Brorbeletsare

은 mc state vid inl 1

개 Comsction

nwt

2         008 Driver 6

”          ‘las forte. mys} Over
1"

6         이

6             = Orivertonger

7            0" 90
너          os

a»

2

2         neni 581 8 시

2          String sal = "DELETE FROM boards MERE beriter=”
a»

B         Lireporedstatonent 기 XB AS

6                              pst = com prparestatenentsa:
a         stm.stString( “winter

고

과         ‘ne a

”                = pstmt ecu

더    Srna grin AE 8 #2 rk
2

2                 staanant 27

더           pstn.close0

35 eateh Exception) 1

*          fe printstackrace)

7 finaly (

Fy        Fann 1 ma (
»          ti
a          ree a1
Pa                  ose
a          1 catch SolException 6) 1)
a         >
*
6 0
wo

eee ee

20.9 데이터 읽기

Preparedstatement® $418 SQL 문의 INSERT, UPDATE, DELETE 244
는 executeUpdate() 메소드를 RAY, Sele lak SELECT 문일 494
executeQuery() MAH AHO} 한다. execueQuery() MEE AAS MIN
Result 4282 ee

재아 re = 대자:

ResultSet 7,
ResuliSer® SELECT #4 718 컬럼으로 구성된 향의 alot, ot ol Ae SELECT 문
은 49004, usemame, userage 컬럼으로 구성된 Resuliser elec,

SELECT userid, 1000. userape 1988 users

‘194 SELECT $0] 가져온 데이터 ol 4개라면 Result] 내부 FRE CHE 같다.

OF ebewois ae4soLs) 33

‘SELECT oi nina eal ae

vse] 902 | 니0006.3
befortist ©                   [3
마티. 9 | 09 | - 즈
9 | 0 | 츠
 | 0“ | ㅋ
따리 90 | 090 | 제
afer                   eae                     fase = nxt
RewakSre| 8 Hb hte 1 eet a8 4 ache lle, PIA 서는 we

가리키는 포인터름 망한다. Resulisers AIM ARE 데이터 행의 St Hel DeforeFst Bt
.2000144 행이 HEH, 최초 AME beforePietg 가리킨다. 따라서 첫번째 oleh Ae] Hes 형
을 위으려면 AA 이동시커야 한다. 이때 next() MEE AEC,

09019 result = rant

1000) WEE AA Ce Oe FRAP

| 이찬 get ole eet, 없으

앞의 ee we ast 형까지는                        sou olga
falset 리턴하는 28-8 + le
vag.                                                        3h e.

에 첫번째 00001) AHS ase7t 된다  레지 기가 재의 Funke as
olga BE

ret ton wea Be         ri aol ga 7B 2
fosutSot ra = prttexectatuery(; __RasltSet rs = pstmt execeteves
sfirs. nex) (                          shies nxt) (

12 254 GOK 연지                  ast $4 ONE OE 8 저리
else (                                1

aterlast 92 0169 2F           iafteriast #25 ojeMe 전우
,

Appendix

1742] 데이터 행간 7G AFH AAO 000) 매소드를 18 RAR, we BFA

alg Moh ch, FE SELECT 푼이 기본카를 aglow Galego 정우에 Mt
hal oleh 8 가저음 AEE while EG 이용래서 next() MAES 반북 BAA ert =]
‘a eh ast 형까지 이동할 때까지) 데이터 Bg eto}, fuser} 리턴되면(80129: oe,
이동할 때) ees BAI

SELECT #41 따라 Resulseeo= 많은 데이터 Ho] AE 수 있기 때문에 66401500을더 이상

001:
데이터행위기
AME 있는 데이터 AM 4 AM) Be Gener MAES OG 4 있다. Hel 데이터 eet

따라서 gevex() MEN ANB, pAatoe dlee] ole 또는 Ue ee 증수 있다.
Resuserofs) 251 G42 부터 시작화기 때문에 userid = 1, username = 2, userage

wu even
String userid = re getStingt):

String vertone = rs gettrira2:
해 wserige = rs.getlnn 3)

만약 SELECT 문에 연산식이나 함수 ho] else 있다면 Vel ole HAM 컬럼 Gwe go}
oF 한다, th 들어 CHES 같은 SELECT 문에서 userage - 1 연산식이 ANB a 순번으로만
918 수 있다, userage - 1은컬럼명이 아니기 sh

OF ewes ae4SOLR) 5

SELECT userid useage - 1                    String userls =
Fon veers                                       rs gettrinaC user
해 wearge = rs grtln82)

(oeoage—1! were 202010 O| oo

.사용자정보 읽기

Aiea}

클레스 작성한다. del                      때
음보 Data hee Hg 이용래서 Geter, Seer, toString!) ARE 자동 AAI
package ca msl se09 xan;

{nore Lonbck ata:

(22t0_ Morstractor, Getter, Setter, haat), mls, toString) 8 신신

18 private int wserte:
11 private String usrenait:
,

userid} winter] 사용자 AMG 가져오는 SELECT 묻은 다음과 eh,

SELECT userid, 100, userpaswor, 10000. userenil

조전정의 gh. 72 cate ARH SOL String 타임 변수 sal ele

38 Appendix

String sal = +

ASS SELECT 문을 심행하기 위해 preparestatement() 메소드로부터
Preparedstatement'® 2, 4 zh 213th,

ast = com preparestatenentsa
fever, enter

excouteQuery() HAE SELECT 428 AMMA Resubser Wer, ward: 기븐개어
rola ae 맞는 Ie 1개이거나, OnI2 if EG OLRM neat() MAEZ} rue at
WAS 데이터 AG User tae ata. BAY

sutSet rs = pst necutetuert:
irs ot) 1                    st doi 8 가은 건우
ser. setserIirs.getString( user i):

else                                 0k we ASH GRE AR
‘Sie 101 0001 219 82.

'509801046700000(4587)는콤비 AR 150의 15100) AMES OHM 받은 ele
HARI AEE users oltHol4 userid” winter] 사용자 정보름가져오는 전체 TH
otc,

oF emote ae4soLs) 37

package ca msl set xan;

Snort java sal este:
Snort jva sal SOLEception:

bic class UserselectBranle
1 public  et mis 000 1

18 "Gamsction coon =
nwt

2         10080 Driver 69

4          ‘las forts on. ysl se Drivers

6

6         ea

7        ‘ae = Oriverinaer

8              yma 96

1”

a»             개마

더         ”

Py

더         /900베떼우 8

2»         Strino

B             Se ee eee 비바
2%               E

7          wie

고

»         reporedStatnent 221 At

”           PrepredStaterent pst = com prpareStatenentsa:
더           stm ststring(, winter)

2

B        76 48, Rie 6 999 8

»            eset 15

%       서태 Re 3

*          User user = 카자

”        cer ntl etre

xe               Usenet. getStringuserare)

‘opendi

”      ser atthertends tring eee
a    ver sthneignrs get):      1600 08
“    = = ms 191: EN ee 08
a           ns
Py   oe ose UE MOA 480.
“          Sumatra NB COED ER 88
6    )
“    개:
a
a        Lreparesstaanant 2
”   pstm-close0
1 eateh Exception ©)
st           ‘ prinstackrace)
52) finaly (
a        fon |= pall) (
se
55          ree a1
56     ‘arn close
a          1 catch SolException 6) 1)
a    ’
위 4
@ 0
an

Lorrie, ernaAB, eros, ce,
sera =winerty corny.

게시물 점보 읽기
이번여는 boards 테이붐에서 bwrter7t wintert] AMIE] BG Ave, 먼저 20.6의

하는
계시물음 29 이상 MEE)

OF eewois ae4soL8) 39

ry                        ]
a
는

비타

molt 8 $8

‘Wel boas dol] 14 행(게시듬)을 저장함 00204 AAG Ate, al 개수와 gel
빚게 MER Alaa, 9 01048 이노테이션을 이용래서 Getter, Setter, toString) AEE
ae AR,

package ca mys seo xan2;

"
2
2
14 private String bfilenoe;
15 private Blob bless:
wy

100때데가 winter’! AH BS IOS SELECT 문은 ChE 같다,

SELECT to, title, beontent,bwriter, bist, bfilenane,bfiledata
208 boos
lee beritor= winter's

조전정의 gh 7 cate wh SELECT 문을 suing 타임 변수 sql Ie

40 Appendix

“SELECT tno, bt, Benton. rite, bite, bfilenae,bfileta ~ +
“FRO boards * +
“WERE bwriter=

Spe SELECT 문을 41971 위해 다음과 감이 preparestatement() 메소드로부터
Preparedstatement'® 2%, 4 zh 213th,

PraparedStatenent pst
pst setString(, “vitor

on preparestatennt sa

executeQuery() MAES SELECT £8 Alef Resubsetg sch AOE 맞는 ABE 가이
므로 while $8 0184) next() AA 7E aloes eet shal eM 데이터 BG Board
ated apa ga,

재아 ra = 대지:
shies. net0) 1
(8H 93 Board 4 A

‘nord sthfileanelrsgetstring( filename’)
‘nord st8FiledsttrsgetlobbFiledta":
ees 해

Syston out prints

,

sysem.out pe board) #80] HBA Board] 05000) MEER RA 받은 리
ks Settc, Hoad®) bled Blob 자이로 Bel Sele com mya. jbe
BlobaGsbi0sb99} go] 의미 없는 타임 BA ete,

oF ebewois ae4soLs) 시

Blob M4] 저장된 바이너리 delete 얻기 위해서는 ChE Qo] 입력 스트림 EE Mie 얻어
ore,

ob bic = board setetstesta)            ob blob = tear gtBFiledatad:
InputStream is =                              bye bytes = Blob etsytes
ob gtbinarystrean:                        bib. eth
은                                          은                        는 wale 보여준다

InpatStroan i = bb getbinay strand:
DoutptStrean 05 = nw FlebutputStreaenp + boar. gtBFilenane):

6

package cab mys seo xa2:

pert joao fietstems
inmort java

회자 java Sons
개다 jova sal

Snort java sa StLExcetion
bic class Boardfelectéxanple
te deine 000 1
Cnnsction coon = null:
wt

선서

7000 river 9
(lass frkanet cons Driver

eae
‘aon = Driverinaper getConection
"icmp loclhart Grishin,
개미
»
ime 5 2 9
String sal
나가이 wn, eortnt, brite, bbe, ileume, Blea * +
ie erie
leven 2
= compreparestatenentsal):

Soin setSrig, waters

7090. © HF, ResultSet BM AOE 91
rcuteer

FesultSet rs = pst. eect
버리자 1
‘Uf 88 SEL Board 2 성신
sehr = fo
sata 00
= sel 더러
ntntrs getStringveontent)
vise             tring bersser
serine tebe)
rs, sebFi leat

라그

een a
Systn out sintnnor)

aie ae
ob blob = boar getsfitdatad
$10 I= ull) 1

netStrean is * blob getinarStrean)

OF ebewois ae4soLs) 43

9           ‘utptsteean 05 = ne Fileoutptstreanslenor” +
ere):

ord. getBFi
so               ss tranetero(n:
Ps               on fh
o               once:
a               sched
a
e         )
a           0001:
6
&       irepoedstatenent 271
a
o
e
»
거
2
B                   7
»               ‘arn closets
8        ) catch StLExeption ©) 0
6         '
nm 4
m4
1

1300190=74. 래하30-보의 88, beontente ls $0. wet
저서

foardinant2, 해하는 SE 님. 레니 2. twriterwin
bases D-41-25, 하여 iy, ldo cons) fe Mh)

1A, bane                _ beritersninter,
wiretn4025. Wilmer, Mies tna
키빼77691

Diledata 289] 18 oles 다음과 20] bflename 컬럼 zk 과일병으로 해서 1006 다
teste he,

시 Appendix

20.10 트랜잭션 처리

있다. 최소 Ae 것은 이 ARGH ele + 없으며, AMI 하나로 본다는 개니다, baba
은 Agee] 모두 BOP 모두 심패래야 한다,

of 들어 계좌 이제는 Oa Aah 입금 shales 구성된 트랜잭선이다. Sab 입금 작업 중 하나
만 성공할 수 없으며 모두 성공하거나 모두 Asolo 한다,

onus)
애매                   매매
fat 이제는 DB SA) 보면 두 개의 계좌 eke Ss Adele, 출금 me tg ab

 소시키고, 입금 MLA eke 중가시킨다, 따라서 chat 같이 두 개의 UPDATE 문이 Bane}
다 두 00046 EE 모두 BSA 모두 Aloo} 하며, 하나만 성공할 수없다.

et orateees)

762 Hat
WATE accunts SET balancevbalance-OPE ERE anon

wea a
DATE accaunts SET balancebalanceori ERE aro- BN

OF eewois ae4soLs) 4s

DBE 트랜잭션을 처리하기 위해 ists ug MU, Ise 내부 Ae 모두 성
Blob, eke Aes ow 들아간다는 Soloed 모두 Al 처리한다.

이기뉴은

vppaTe,

계좌 oats} 같이 두가지 UPDATE 문을 실행할 때 art 된다, 출금 작업이 Ste 바로 sl

이 되기 때문에 입금 작의 A 여부와 ato 출금 작인 별도 처리된다,

Se joceth Sts Ae 자동 A718 Fe, AB APRA a
AER 할수 있다 다음

0
AB ADL hee] a BAe SE hse MKB ARE 수 있다,

cooncomits 1821
omnrllbeck (E459)

sebaatg 위한 Webel 코드 작성 ete chet ee,

Conection conn = null:

a8 AL

18 > 모두 90 커리
seas 02
) catch Exception) 1
(

TRS) 모두 시 221

‘oonrolitack
7 eaten (ikExcention et) 1)

시 Appendix

10900 (
0000
wt
bes 38 카미 켜기
en sethutoommi tre)
ea 31
ar closet:
atch (StLErception «) ()

‘He ota accounts Holos] 111-111-1111 계좌에서 222-222-2222 A812. 100008)
을 ole] 위해 트랜잭션 ates 한다.

package chat sal sect

해야 jva sal StLEcont

public class Transationtanple 1
Dubie static vid minting) aos) 1.

개 때 coon = nl
nowt

2         1000 river

3    hase ar ce Ber
«

6         eae

6         cam = Dei         -getComecion

”             cms oclhas:396rthisisina,
8          a0",

”          ‘sal

a         »

2

2         sees 시키

oF soos

o

‘opendi

Wades
|

182 2
Sting sal = "WORE accounts SET balnce-balonce- MERE 0007
nt 해저 * comn.prepareStatenet(salt):
:

pte

cnt we 6) roe ton 855A O28

pst close

7002 Hat

Sting 5022 = "WORTE accounts SET balnceralancet MERE aor
eaten nn = com preparestatenentisa2i;

ro                90011
헤아 =81 ‘Sew seu Cte 130% 38
pst clos

TSS HS we Ba
com.cn

Tse AS we it 지뢰

comnrollsackd:

Je Guten of

Inna nla we
aac

ut

“car seston tre

) cto) tention #0

제 때 a

.39라인에서 입금 Aa 333-383-3833'28 다르게 주면 1052가 00] 되므로 41라인에서 에
‘hea, 예외 처리 코드 51라신에서 steel 되면 aS 실패 else Sat
A} 입금 iol eke We 않는다.

2            pst set String, “35-38-3589;

자 oot 이
ova Jog ception: BAS Bt
at chase see. TronsactionErarole sin TansactiorBxanpe. joe)

seagate olf: Gatos 자동 커및 기능음커뒤야 한다. 앞의 alae 더 이상

see,                            득의 ie
comment 사용할 때 Bao MOL

oon

aH
SHS Wh 6 SALON,

20.11 게시판 구현

지지                  oe meme(alee) 또는                  ie

Nghe Fel 보자. AMIE 기본적인 CRUD (Creat, Read, Update, Delete) 71521 4
of 있어 가장 Be ale 주제 중 하나이다,

메인 메뉴

50 Appendix

ug 881
ro writer ate          ‘le
1 winter 20-40-27 ABO 28 AB WRLC,

2 winter 20-40-27 ABE GO Bau.

fu 95: 기제 | 21108 1 31010 1 Et
Ip:

편저 list(), mainMenu(), main() ILLES 다음과 같이 작성한다, main() 메소드는
BoardExample 4 생성하교 16) MAE RARE, 1611) EEE ANE SE OM
fat mainMenu () EH BAC,

package chat sal sect

1
2

3 public class tordbrameet (

4 애매

5

6 ikenstrtoe

7

ss

9 public void Lst0 1

”             emout rintIn:

개 ㅣ SystenavtsrintinCPNe 쿠타

72 Syston avt. sini

73 Systenavtsrintf estas Neha, 개. writer “te, “title:
14 Syston avt.srintin

15 SystenavtsrinttCeést-2st-6st45 가

6         “hy winter", 202.9127, “AUB SAB BAB;

17 SystenavtsrinttCeés- aster,

®           Ey winter, 1022.01.27, “BARE BOL RAE

19 ester
ao)

oF soos

e048) 51

2
22 pubtic void minted 1
23 ㅣ Systenoutorintind:

8 public stati void main(String 0700: 1
31 BoardEsootetdoardtxnple = ew BardExamplet()
건 wardStople-tist):

,

메인 os 84 기능

we sa

개 writer date          title

는 tne gaze? incu 28 00049
2 winter 220127 BRE G0,

219

me oe 기제       31000 | 46eit

ue a

ss 011 AE IO

us 88)

개 writer oe          tite

1 winter 20127 MiB 오신 a BBE,

52 Appendix

2 winter 2020127 902 Bo! ABLE,

Im: 기제 | 21108 1 31080 | Et
때 ast 2

sm rend) ORE tL

bug 881

ro writer date          se

wimer tone? 928 80049
> timer oo 지기 | eae OM

we sa
ro writer sate  se

1 winter 2002.0127 Aa 오신 28 BBC
2 winter 2020127 RE 801 BLE,

Im: 기제 | 21108 1 31080 | Et
때 ast

키보드 입력을 받기 위해 Scanner BE 추가하고(7라인), mainMenu() EEA 키보드 입
8871 위해 0001406. MEEK 호총한다(30라인]. 그리고 메뉴 선태 ese 따라 해당 메소
8 호한다133~34라인,

OF semis ae4soLR) 59

package champs sect:

snort jova uti Seamer:

2700

'
2

2

4

5) pubic cass Boardéxomled |

6

7 private Scomer scamer = new Scomerisysten in):
n

°

Monstrctor

estos
12 piblic void tist0 1

7 ㅣ Systm ave siting:
74 Systenovesrintinc PIN 8a

15 Syston avt sini

16 System aut sri Geek, eater, ate, “ites
Sp nt in
1      ema pint (-e6s- 12ers

»            “neers Ia .01.27- Dor Be 28 BOB

개 Systenout orintfrésetasetesrsts Wr

a      winter, 20228.27, “BE BO] BOUL

22 sinensis

Boo

2»

25 pubtic void ainters 1

2% Syston out print

21 Syston or print

Beamon a: te 12000 12091 400
2B systenout ori  a

String sorts

system avt aint

atc
ss 9 cm
때 가
case 3° elses
co Sot
,

~

‘opendi

wo)

a
서 public void create (

42" Systemout printinm crstel) AS sae:
sto

46 pubtic void read

47“ Systenout rintinm reat) 미스 SH
세 이 sto

0

a

위 public void clear

인 Synaral) 5 HOR
Sisto

se

55

ae wt 0 (

Sema

a

버

에 public static void moiiStringl 0007 |

61" toardearpe? bosrdéxnoie = new Soaaxonole20:
2 beardeanple ist

a

“

Board 클래스 작성

boards 테이붐의한 개의 행(게시물)음저장함 Board SHAG ele, el Ae 맞
AEG Alek, #4 @Data ole ole4g ola" Getter, Setter, toString) ALA 자
AAO,

OF Memos ae4SOLR) 55

package champs sect:

‘nore java vil. Da
{nore Lonbck Data;

18 private String beotents
개 private String brite:
12 private date tat
Boy

‘aol 있지만.         는
제의함 것이므로 Bee 선언하지

게시물 목록 기능
boards 테이베서 모든 게시물 AMER 가온 다음 게시물 BO eel 보자.

개 writer 제          서래

3 winter 28.27 wa 38
2 winter 20028127 ㅣ 30스키스
기 winer | 2020127 eee

fy ep 가제 | 21009 | 31010 | 43
때 센티

에 Appendix

DB Gao) WASHES Connection WES 추가하고(15라인). 생성자에서 DB AE 한다

(a8-332te).

11606) ME 48H 6741),

개

2
«
6
6
”
개
너

2

본

며

Se ee EES

package chat sal sect

해다 java sal omection;
Snort jva sal. Drivertanger:
Pranaredtat

해다 jva sa    r
nore jva sal ResultSet:
게다 jva sal SQLException:
Inport joa wt.

Inport 00 ays sect Boor:
be cas ttre (

Ce 자아 오대.
beivate Comection com:

Monstrctor
bic Boaraxorele30 1

100 river 회
hase ar ce Ber

ea
cam = Dri         -getComecion
cms oclhas:3306rthisisina,
ia"
개미

»

1 eatchtaception © |
printstackraced)
crit:

OF eewois aeasoLs) 57

‘opendi

inetd
bli void 1ist0 1

‘nae 92a ot
system ove.

Syreont orn O08 AP
System avt siti
Sytem ave grin Gab Teh,“ “ait te
system avt siti

건:

ft eum 22279 am)

econ
“SET io ite, tata, bite, =
“Fan boards
OER BY bo OES
reStatenntpstnt = com prepreStatenenttsl):
ItSet rs = 대리:
sino ont
board

toate
Sptman rin 496 w
oor

ms 자태
rite

moo

명
7 6

게시물 생성 기능
메인 HM Create’ Aiea 새로운 ANNES 제목. 내용, a IME ea, 보
A ofA 10K Asta boards plo 새로운 AAI Ho] 저장되도록 해보자,

00000

nots reat | 21105
a 1

oe at
aR: Ot 78
ae re 405 외가 298 BLE

브그 95: 9.0 | 20003
a 1

we sa
ro writer ate     ‘le

‘               zat) a 대
3 inter 2002위27 | 89 래

2 winter Dona aaa

1

winter atay ee

000

머-9094이스@테4460401 50

메인 soba Great's ASRS ASHE reate() LAE CHEE Zo] FARE,

기 09 sa
뀌

32 public void crested (

33 ares wo

와 Board baad = aw Bose:

38 Systenout orintinat 기신 9

36 Systenovt orn:

7

oo

$9 Kardsedetetscmr tines

78 systenavt sina

71 toard setBeriteriscommer retina)

1

7

r                                                      "
15

16

1

1                   "

1        cards HOME AA 33

we       tot

m         Sting sal =

1m          WBE 1160 boars ttle, bert, biter bite) = +
13        0465 0... ren

14         PraparedStatenent pst = com preporeStatenentsals
15         fete settringt, cnr geile

16         stat setString2, nord gtBconent:

내         pst setString3, board gtberiter

18      pst eects

1”         stat lose

ve        ets ction ©

m            onsets

m         peri

1%       ’

mF

80 Appendix

5
개 여세 매해
27 ists

)

2
ve sis 8

게시물 읽기 기능
tah tat                            sens,

ae INNES dah a 보자.

we sa

ro writer date          se

att 009 가 A 며
2 8H

inter 2902127 aaa
winter aay se

3 winter amp
2
1

1998 sou
배스
ee

제 089 78 시트
Cis rer ioe 994 자 BLE
전재

see 22-0

8

메인 oa 2 Rea Aste of BAS read() ALES CAB ol FH

기 yo sa

1

130 pubic vid read 1

wh este)

732 SystenavtsrintInc (sa 871%:

133 Systenout ori

134 int bro = Inteper prseft(scamer.netLine):
13

별 na we 00 790 에

7

eden sal =

1»      “SELECT tr, sie content, baste, bts ©
ve      “Fan boo

때          er 배아

1        PrepredStatenentpstnt = com prparestatenntsa:
10

때

us

M6

1

ve

we

10

더

12

18

154

15

16                  oe

17    Spree grtineg rd gree
18     System ave sritinC esis

18

16       close

기           버버

2 cateh Exception) 1

2 Appendix

16           printstackraced)
nit:

18
6
16
17 ie 88 a8
resto:
16
m
깨 18 63
게시물 수정 기능
FURS 읽기에서 보조 ies 추가하고. 보조 EN Updae's 선태했을 때 제목, 내용, 작성
의                                     그리고 보초메뉴에서 1,0
oltel 해당 nahn 수정하도록 A,

rr
br 9

20000 1318 |

a 때: 719
fe ak

rr
sag: Hol 2010
Me: Sate 380. 와요
aa sorira

fe ak

OF semis ae4soL8) 69

read() 메소드에서 보조 메뉴 “Update | 2.Delete | 3.Lst's Aish, 보조 HA
1.Update' Aste update() MAGA, 2Delew' Aha deete() AEF} RSI
5, update() REE 매게값으로 We Board Ait 429814 boards el) AE

us 88)
개 writer ante          tite

시이 mer 2002-80-27 ge 7 06 다
3 seria 20207 wo, 머드

2 winter 20028127 aan

기. winter mera hy

fy 9: Greate | 21009 | 31010 | Est
때 센티

as pees 한다.

기 ro sa

계 public void read) (

752 systenoutprintin

755. Systonout prints: ㆍ + board petBcontent)
Sytem outprintine 2° + board getberster)

757 Systenoutprintincwe *+

1501122 ty 09

159 Syston out pit

161 Spstonout print £9”)
762 String nena = scanner net inet:
163 Systenout prints

765. iment east

‘opendi

109091300계1:
) ese ifierto eualst29) 1
Seletetnod

i undotetBoard board 1

System out srint=83“
tears. setBeriterscaner nor ine:
Systn aut. sini                         7
Stan out srintn( = Oy 1.0
Systn out arin Ht
String meno = scanner.next inl)
stent cemls

cards AONE AN a 수전

ot

String

에 bcd SET butler, brotent7, brite * +
WERE toe”

PrapareStatennt pstmt = com prepareStatenentsa):

pret setString, tnord. geste)

set setString2,bnord getconent)

set setString3,bnord.gtberiter 0):

pet etn, board getbo0)

eet vaca

Yeh actin @

ntStackrace

OF emis Re4SOLE) 5

25
26 ie 때 as

27 sto:
mm)
29
20 9 831
게시물 삭제 기능

게시물 회기의 보조 메뉴에서 2_Delete 를 AMHSAR 때 boards OHI 해당 ARG 삭지하
5 a

개 writer date          title

시 mer 2002-00-27 009 718 ate 다
3 ering 20207 0009 Boe,

2 winter 202-8.97

기. winter 2020-40-27

I es 1.Geste | 21009 | 31010 | 4st
te ask 2

190 wou
to

se me 시티

Cis tr ioe BHA a BLE
ed

sea 2022.01.27

i Vain ve | a
ar

8 Append

bug 881

1% 9 reat | 2.x
ya:

writer ate          se

ering 200-8027 wo BOR
winter 2002127 ㅣ aan
winter aay se

clear | 468

NE 수정 기능을 구현할 때 보조 메뉴에서 2. Delete AH delete) ETF BSI
도록 하였다, 40100) MASH chat ol 수정해 WARES 받은 Board 적체에서 600 임
oF boards Hel ots 해당 AAHES Aaah te,

1

no

UBRSPSRVSSRLEES

oi 8

vod deleteioard board) 1
‘Mande AON A 2 시게
tot

String sql = DELETE FOU boards WERE bnow":
PrepredStatenent pstet = conn preparestatennt a:
pstm.stintt board gett):

tm eecitldate)
pstm-close

(exception 0)

co prinstackraced)

0

rue 54 a8
Ist:
as

OF emote ae4soLs) 67

게시물 전체 삭제 기능
메인 메뉴에서 3 clear ARI. we 메뉴에서 Ol AIRE boards oh A
계실 A Ae a,

3 seria 20200 00 09 a,
2 winter 20028127 aan
기. winter med ey

lear | 4b
eka
보그 1.0 | 21001
a
owe sa
se writer ante             site
fy 9: Greate | 21009 | 31010 | Est
때 센티
메인 soba 3, Clears FRR a BARS clear) ME EHH 같이 수정한다.
기 ro sa
26
20

ub void clear’) (

88 Appendix

Basi artrimin 2 aA:
283 systenoutorintin
2a Satenavtgrntin-sa ay: 7.06 1 2.00417
D1 Systenont int 8 기
22 String nenalo = scanrer.next ine
28 | teas (
24                 HNL 개 2 시시
25         oon
2          String sal = 012 TALE boards:
20                  Statement pstmt cor proareStatenet(sa)
2          개개:
20               ‘lose:
oe        ) catch xcetion ) (
더           ‘sprintstackrace)
22          eats
23         ’
we
25
26 여태 a8
250 00 19
we)
29
26810 8
종료기능
메인 eA Ext’ AM Connection a 프로그램을 HAA 보자,
1910 881

ro writer ate          ‘le

기은 9 create
때 ast

= ue aa

OF ebewois ae4soL8) 69

기 yo sa

29

20 public void 0 1

26 래셔 te mal) 1

20           tt

20             on clos

lene 테이 (

2

26

2                Laut srintinc Aue) 2 기

xs Sptmentor

wo)

mm

2 yo 8
10000 32 ona ng tte.

은                         ANB TIAL 7h 8

abuse 구현래보길 바란다,

70 Appendix

