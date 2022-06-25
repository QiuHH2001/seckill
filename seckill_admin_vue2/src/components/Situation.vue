<template>
  <div>
    <div style="display: flex">
      <el-container style="height: 100%">
        <el-main>
          <div style="padding: 8px 0; display: flex">
            <div style="flex: 1">
            <el-input size="medium" prefix-icon="el-icon-search" style="width:180px; margin-right:10px" v-model="keyword" placeholder="请输入产品名"></el-input>
              <el-button
                type="primary"
                size="medium"
                @click="queryByProduct"
                >查询</el-button
              >
            </div>
          </div>

          <el-table
            height="600"
            :data="tableData"
            border
            stripe
            style="font-size: 15px; font-weight: bold"
            :header-cell-style="{
              background: '#ccc',
              fontSize: '18px',
            }"
          >
            <!-- <el-table-column prop="id" label="ID" width="80">
            </el-table-column> -->
            <el-table-column prop="name" label="名称" width="240">
            </el-table-column>
            <el-table-column prop="price" label="单价" width="200">
            </el-table-column>
            <el-table-column prop="quantity" label="数量" width="200">
            </el-table-column>
            <el-table-column prop="username" label="下单用户" width="220">
            </el-table-column>
            <el-table-column prop="time" label="下单时间">
            </el-table-column>
          </el-table>
        </el-main>
      </el-container>
    </div>
  </div>
</template>

<script>
export default {
  name:'situation',
  data() {
    return {
      tableData:[],
      keyword:''
    }
  },

  methods: {
    load(){
      this.request.get('/admin/order').then(res => {
        if (res.code === 200) {
          this.tableData = res.data
        }
        else{
          this.$message({
            type: 'warning',
            message: res.message
          });
        }
      })
    },
    queryByProduct(){
      this.request.get("/admin/" + this.keyword).then(res => {
        console.log(this.keyword)
        if(res.code === 200){
          this.tableData = res.data
        }
        else{
          this.$message({
            type: 'warning',
            message: res.message
          });
        }
      })
    }
  },
  created(){
    this.load()
  }
}
</script>

<style>

</style>