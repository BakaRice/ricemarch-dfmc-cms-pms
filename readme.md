## 零部件管理系统

> ©2021 Rice March
>
> ricemarch@foxmail.com

### 全局细节

- [ ] 登录拦截器
- [ ] Request日志记录及存储

### 员工管理

- [ ] ①员工信息管理：可以进行用户注册，以及登录系统，对自己的信息进行查看和修改，统计并查看加工工时。（用户登录、注册、个人信息查看和修改）

    1. - [x] 员工注册
    2. - [x] 员工登录
    3. - [ ] 员工信息查看和修改
    4. - [ ] 个人信息查看和修改

- [ ] ②生产班次管理：管理人员对员工进行工作班次的安排，通过生产安排设置拟定工时，并且能够生产工作安排报表。
- [ ] ③考勤绩效管理
  ：对员工进行实时出勤查询，基本出勤处理，自动判断迟到、早退、缺勤的人员及有效打卡时间内的打卡明细情况加班自动统计，异常事项处理，对因公事耽误打卡的人员可进行补卡处理，对请假员工可进行请假处理，对某人员、某班次的时间变动可进行工时调整处理，月底统计进将自动计算请假天数。对员工的工作时长，工作量，废品率，作业违规信息进行记录分析和管理，并且能够生成报表。
- [ ] ④员工权限管理：角色分为 管理人员，保全人员（设备维修保障），质量保证人员（检查班），生产作业人员（生产车间），通过角色对相应模块进行权限区分，不同级别的用户可以进行员工权限管理，设置员工权限等。

### 仓储管理

- [ ] ①零件仓储管理：当操作工将零件（例
  离合器盖，模具号797，零零件号4870014495）所有工序加工完成后，将产品存入库内，可以查看产品数量，产品信息，查看具体存储位置编号，根据现有数量安排产品的作业计划，查看客户要求，根据客户要求形成出库单，提出仓库。
- [ ] ②备件仓储管理：机械加工设备的损耗率一般较高，一般企业会对所拥有的机械加工设备加以备件存储，在发生机械故障（如掉刀，撞机）时及时更换备件。备件管理模块，能够都现有备件信息进行存储，查看备件数量，存放仓库位置，备件价格，
  备件有效期，备件使用情况。在需要使用备件时，从备件库中提出备件。
- [ ] ③库存计划管理：对产品进行库存计划的制订，确定预定产品的时间以及数量。分析产品需求的平均值、需求变化以及补货计划等。对库存数量进行库存预警。
- [ ] ④出入库数据管理：对出入库的产品数据进行管理，记录出入库的产品流向以及出库类型，销售出库或者其他出库，可以自动生成出库单号，可以区分正常出库、废弃出库等不同的出库方式；根据出入库的方式自动生成出入库报表。

### 设备管理

- [ ] 
  ①加工设备管理：保全班（维修人员）通过设备加工管理对生产车间设备进行现场统计及监控，标注每台机器的信息（开机时间，设备类型，设备编号），将根据产出判断当前机器状态（生产，异常停机，维修停机等），手动修改机器状态，分析每台机械加工设备的设备生产率以及产出废品率。
- [ ] ②检测仪器管理：检查班（检查人员）通过检测仪器管理对加工车间内以及质检中心的检测仪器进行统计和管理，能够记录检测仪器的使用记录及机器状态。修改机器状态等。
- [ ] ③使用计划管理：大型检测仪器及加工设备中的试验台等需要提供给多个员工进行使用，对设备的使用计划进行管理，提高设备的使用效率，避免设备空转，造成资源浪费。

### 加工管理

- [ ] ①零件加工数据管理：零件进行加工时，机械加工设备会产生对应零件的加工数据（单个工件加工时间，对应加工点加工时间），对于每一个零件的加工时数据可以进行采集和管理。用于分析和优化零件加工过程控制。
- [ ] 
  ②零件测量数据管理：零件加工完成后会需要进行作业工人自检和检查班工人抽检至少两步骤，通过零件的编号可以进行数据记录。使用机械加工设备进行机械加工，从加工开始进行组合测量，批量加工开始就是每八件测量一次，以此制作测量报告，填写记录报表，加工尾件，进行尾件检查（终检）。完成测量后可以进行零件登记。
- [ ] 
  ③生产作业流程管理：零件生产前会进行生产排序（一个零件需要经过多个机器的不同方式加工），按照生产次序进行生产，生产时有严格的流程管理，能够通过零件的唯一识别码对进行流程进行管理，如果没有进行上一流程的加工，在后续流程中会进行预警,将会无法完成当前生产。例：零件加工后不进行检测和登记就无法录入下一零件信息。
- [ ] ④报废品管理：当零件加工完成后发现出现误差，需要进行零件报废时，进行报废登记以及通过相邻零件测量数据进行分析，并能生成废品信息报表以及对废品率等进行预警。

### 质量管理

- [ ] 
  ①质量级别管理：根据产品需求以及客户要求，对零件进行质量分级，添加多种级别质量要求。能够设置自定义检测要求，如抽检密度，检测精度要求等，区分出自定义的质量级别。如：高级别质量要求需要进行全部产品检测和复检，普通级别产品仅需进行低密度抽检。
- [ ] 
  ②质量检测管理：检查班（检查人员）会对根据生产零件的级别要求，分为全检，抽检。对于全检的零件产品，进行逐一检查，标记检查工具（三坐标检查，孔径深度检查等）及检查数据，进行产品标注，对于抽检产品，对于即将入库产品，进行随机数抽检，如果满足入库要求，即入库。同时进行零件质量分析，研判该批次零件生产的不合格率预测。机器可以自动输出监测数据，也可以手动记录数据。
- [ ] ③随机抽检管理：通过批次随机抽检，时段随机抽检，人员随机抽检等方式进行随机抽检，抽取对应随机零件编号，进行复检。对抽检方式及抽检质量就级别要求进行管理，同时记录数据生成随机抽检报告。
- [ ] ④批次产品质量数据分析：对于生产批次产品进行数据分析,通过数据检查做出产品质量分析报告。

### 流程

先把user内容做好 然後做一點倉儲的内容 之後直接拆分微服務