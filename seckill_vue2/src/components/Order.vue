<template>
  <div>
    <div style="margin-top:30px; margin-left:20px">
      <el-input
        v-model="keyword"
        prefix-icon="el-icon-search"
        style="width: 200px; margin-right: 10px"
        placeholder="请输入关键字"
      >
      </el-input>
      <el-button type="primary">搜索</el-button>
    </div>
    <div style="margin-top:10px;margin-left: 20px">
      <el-table
        height="600"
        :data="order"
        border
        stripe
        style="font-size: 15px; font-weight: bold; width:98%"
        :header-cell-style="{
          background: '#ccc',
          fontSize: '18px',
        }"
      >
        <!-- <el-table-column prop="id" label="ID" width="80">
            </el-table-column> -->
        <el-table-column prop="time" label="下单时间" width="280">
        </el-table-column>
        <el-table-column prop="name" label="产品名称" width="200">
        </el-table-column>
        <el-table-column prop="quantity" label="数量" width="200">
        </el-table-column>
        <el-table-column prop="price" label="价格" width="200">
        </el-table-column>
        <el-table-column prop="username" label="下单用户名"> </el-table-column>
      </el-table>
    </div>
  </div>
</template>
  </div>
</template>

<script>
export default {
  name: "order",
  data() {
    return {
      user: localStorage.getItem("user") ? JSON.parse(localStorage.getItem("user")) : {},
      order:[]
    }
  },
  created(){
    this.load()
  },
  methods: {
    load(){
      this.request.post("/order/",this.user).then(res => {
        console.log(this.user.id)
        console.log(res)
        this.order = res.data
      })
    }
  },
};
</script>

<style>
</style>