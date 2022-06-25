<template>
  <div style="display:flex">
    <el-container style="height:100%">
        <el-main>
          <div style="padding: 10px 0; display: flex">
            <div style="flex: 1">
              <el-input
                v-model="keyword"
                prefix-icon="el-icon-search"
                style="width: 200px; margin-right: 10px"
                placeholder="请输入关键字"
              >
              </el-input>
              <el-button type="primary">搜索</el-button>
            </div>

            <!-- <div>
              <el-button size="large" round>秒杀未开始</el-button>
              <el-button size="large" type="primary" round>秒杀进行中</el-button>
              <el-button size="large" type="danger" round>秒杀已结束</el-button>
            </div> -->
          </div>

          <el-table
          height="600"
            :data="tableData"
            border
            stripe
            style="font-size:15px; font-weight: bold"
            :header-cell-style="{
              background: '#ccc',
              fontSize: '18px',
            }"
          >
            <!-- <el-table-column prop="id" label="ID" width="80">
            </el-table-column> -->
            <el-table-column  prop="name" label="名称" width="140">
            </el-table-column>

            <el-table-column prop="price" label="单价" width="120">
            </el-table-column>
            <el-table-column prop="quantity" label="数量" width="100">
            </el-table-column>
            <el-table-column prop="seckillTime" label="开始时间">
            </el-table-column>
            <el-table-column prop="endTime" label="结束时间">
            </el-table-column>
            <el-table-column label="操作" width="120">
              <template slot-scope="scope">
                <el-button
                  v-show="isShow"
                  type="primary"
                  size="large"
                  @click="handleEdit(scope.$index, scope.row)"
                  >立即秒杀</el-button
                >
              </template>
            </el-table-column>
          </el-table>
          <!-- <div style="padding: 10px 0">
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="currentPage4"
              :page-sizes="[5, 10, 15, 20]"
              :page-size="10"
              layout="total, sizes, prev, pager, next, jumper"
              :total="400"
            >
            </el-pagination>
          </div> -->
        </el-main>
      </el-container>
  </div>
</template>

<script>
export default {
    name: "SeckillProduct",
    data() {
        return {
            user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
            tableData: [],
            keyword: "",
            image:require('../assets/img/iphone12pro.png'),
            order:{
              productId:0,
              userId:0
            },
            isShow: true
        };
    },
    created() {
        this.load(),
        console.log(this.img)
    },
    methods: {
        load() {
            this.request.get("/product").then(res => {
                console.log(res);
                this.tableData = res.data;
            });
        },
        handleEdit(index, row) {
            // this.$message({
            //     message: '您已秒杀过该商品，不能再次秒杀',
            //     type: 'warning'
            //   });

            // this.$alert("恭喜您，秒杀成功！", "通知", {
            //     confirmButtonText: "确定",
            // });
            let nowTime = this.formatDate('YY-MM-DD hh:mm:ss')
            console.log("now",nowTime)
            let endTime = this.tableData[index].endTime
            console.log("end", endTime)

            let dates3 = new Date(nowTime);
            let dates4 = new Date(endTime);
            if (dates3 > dates4) {
              this.$message({
                showClose:true,
                message: "秒杀已结束",
                type: 'warning'
              });
              // this.isShow = false
              return
            }




            let time = this.tableData[index].seckillTime
            console.log("time",time)
            let now = this.formatDate('YY-MM-DD hh:mm:ss')
            console.log("now", now)

            let dates1 = new Date(time);
            let dates2 = new Date(now);
            if (dates1 > dates2) {
              this.$message({
                showClose:true,
                message: "秒杀未开始",
                type: 'warning'
              });
              // this.isShow = false
              return
            }
            console.log("失败了")

            console.log("index" + index, "row" + row)
            console.log(this.tableData[0].id)
            this.order.userId = this.user.id,
            this.order.productId = this.tableData[index].id
            console.log(this.order)

            this.request.post("/product/seckill", this.order).then(res => {
              if(res.code === 200){
                this.$message({
                  showClose:true,
                  message: "恭喜您，秒杀成功！",
                  type: 'success'
                });
                this.$router.push("/order")
              }else{
                this.$alert(res.message, "通知", {
                  confirmButtonText: "确定",
                });
              }
            })
        },
        formatDate (fmt) {
          const date = new Date()
          const o = {
            'Y+': date.getFullYear(),
            'M+': date.getMonth() + 1, // 月
            'D+': date.getDate(), // 日
            'h+': date.getHours(), // 时
            'm+': date.getMinutes(), // 分
            's+': date.getSeconds(), // 秒
            W: date.getDay() // 周
          }
          for (let k in o) {
            if (new RegExp('(' + k + ')').test(fmt)) {
              fmt = fmt.replace(RegExp.$1, () => {
                if (k === 'W') {
                  // 星期几
                  const week = ['日', '一', '二', '三', '四', '五', '六']
                  return week[o[k]]
                } else if (k === 'Y+' || RegExp.$1.length === 1) {
                  // 年份 or 小于10不加0
                  return o[k]
                } else {
                  return ('00' + o[k]).substr(('' + o[k]).length) // 小于10补位0
                }
              })
            }
          }
          return fmt
        }

    },
};
</script>

<style scoped>
.el-dropdown-link:hover {
  color: #409eff;
}
</style>