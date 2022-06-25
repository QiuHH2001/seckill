<template>
  <div>
    <div style="display: flex">
      <el-container style="height: 100%">
        <el-main>
          <div style="padding: 8px 0; display: flex">
            <div style="flex: 1">
              <el-button
                type="primary"
                size="medium"
                @click="dialogFormVisible = true"
                >新增</el-button
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
            <el-table-column prop="name" label="名称" width="140">
            </el-table-column>
            <el-table-column prop="price" label="单价" width="120">
            </el-table-column>
            <el-table-column prop="quantity" label="数量" width="100">
            </el-table-column>
            <el-table-column prop="seckillTime" label="开始时间">
            </el-table-column>
            <el-table-column prop="endTime" label="结束时间"> </el-table-column>
            <el-table-column label="操作" width="120">
              <template slot-scope="scope">
                <el-button
                  type="danger"
                  size="large"
                  @click="handleDelete(scope.$index,scope.row)"
                  >删除</el-button
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
    <div>
      <el-dialog title="新增产品" :visible.sync="dialogFormVisible">
        <el-form
          :model="ruleForm"
          :rules="rules"
          ref="product"
          label-width="100px"
          class="demo-ruleForm"
          style="width: 500px"
          size="medium"
        >
          <el-form-item label="产品名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
          </el-form-item>
          <el-form-item label="数量" prop="quantity">
            <el-input v-model.number="ruleForm.quantity"></el-input>
          </el-form-item>
          <el-form-item label="单价" prop="price">
            <el-input v-model.number="ruleForm.price"></el-input>
          </el-form-item>
          <el-form-item label="开始时间" required>
            <el-col :span="11">
              <el-form-item prop="seckillTime" style="width:200px">
                <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                  type="datetime"
                  placeholder="选择日期"
                  v-model="ruleForm.seckillTime"
                  style="width: 100%"
                ></el-date-picker>
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item label="结束时间" required>
            <el-col :span="11">
              <el-form-item prop="endTime" style="width:200px">
                <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                  type="datetime"
                  placeholder="选择日期"
                  v-model="ruleForm.endTime"
                  style="width: 100%"
                ></el-date-picker>
              </el-form-item>
            </el-col>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="submitForm"
              >立即创建</el-button
            >
            <el-button @click="resetForm()">重置</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  name: "setting",
  data() {
    return {
      dialogFormVisible: false,
      tableData: [],
      ruleForm: {
        name: "",
        quantity: "",
        price: "",
        seckillTime: "",
        endTime: ""
      },
      rules: {
        name: [{ required: true, message: "请输入活动名称", trigger: "blur" }],
        quantity: [{ required: true, type:'number', message: "请输入数字", trigger: "blur" }],
        price: [{ required: true, type:'number', message: "请输入数字", trigger: "blur" }],
        seckillTime: [
          {
            // type: "datetime",
            required: true,
            message: "请选择日期",
            trigger: "change",
          },
        ],
        endTime: [
          {
            // type: "datetime",
            required: true,
            message: "请选择时间",
            trigger: "change",
          },
        ],
      },
    };
  },
  methods: {
    load() {
      this.request.get("/admin/product").then((res) => {
        if (res.code === 200) {
          this.tableData = res.data;
        console.log(res);
        }else{
          this.$message({
            type: 'warning',
            message: res.message
          });
        }
      });
    },
    handleDelete(index,row) {
      console.log(this.tableData[index])
      this.$confirm('此操作将永久删除该产品, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.request.post("/product/delete",this.tableData[index]).then(res => {
            if(res.code === 200){
              this.load()
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
            }
            else{
              this.$message({
                type: 'error',
                message: res.message
              });
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
    },
    submitForm() {
      this.$refs['product'].validate((valid) => {
        if (valid) {
          // console.log(this.ruleForm.seckillTime)
          this.request.post("/product/add", this.ruleForm).then(res => {
            console.log(this.ruleForm)
            console.log(res)
            if (res.code === 200) {
              this.$refs['product'].resetFields()
              console.log(this.ruleForm.seckillTime)
              this.dialogFormVisible = false;
              this.load()
              this.$message({
                message: "新增成功！",
                type: "success",
              });
            }else{
              this.$message({
                message: this.ruleForm.seckillTime,
                type: "error",
              });
            }
          });
        }
      });
    },
    resetForm() {},
  },
  created() {
    this.load();
  },
};
</script>

<style>
</style>