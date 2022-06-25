<template>
  <div class="wrapper-form">
    <h3>湖南三湘银行秒杀管理系统</h3>
      <el-form
        :model="admin"
        :rules="rules"
        ref="adminform"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="用户名" prop="name">
          <el-input size="medium" prefix-icon="el-icon-user" v-model="admin.name" placeholder="用户名" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input size="medium" prefix-icon="el-icon-lock" v-model="admin.password" placeholder="密码" style="width:300px" show-password></el-input>
        </el-form-item>

        <el-form-item>
          <el-button style="margin-top = 50px; margin-left = 50px ;margin-right:50px" type="primary" @click="login" size="medium">登录</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
export default {
    name:'login',
    data() {
    return {
      admin: {
        name: "",
        password: ""
      },
      rules: {
        name: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 3, max: 20, message: "长度在 3 到 20 个字符", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 20, message: "长度在 6 到 20 个字符", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    login(){
      this.$refs['adminform'].validate((valid) => {
        if(valid){
          this.request.post("/admin/login", this.admin).then(res => {
            console.log(res)
            if(res.code === 200){
              localStorage.setItem("admin", JSON.stringify(res.data))
              this.$message.success("登录成功")
              this.$router.push("/")
            }
            else{
              this.$message.error(res.message)
            }
          })
        }
        else{
          this.$message.error("用户名或密码格式不正确")
          console.log("用户名或密码格式不正确")
          return false
        }
      })
    },
    resetForm(){
      this.user.identity = ""
      this.user.password = ""
    }
  },
}
</script>

<style scoped>
h3{
  margin-left: 70px;
  font-size: 30px;
}
.wrapper-form {
  width: 500px;
  height: 300px;
  margin: auto;
  margin-top: 200px;
  padding-top: 50px;
  background-color: rgb(164, 213, 245);
  border-radius: 8px;
}
.demo-ruleForm{
  padding: 20px;
  padding-left: 30px;
}
</style>