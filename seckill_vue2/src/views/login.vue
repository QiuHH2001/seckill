<template>
    <div class="wrapper-form">
    <h3>湖南三湘银行秒杀系统</h3>
      <el-form
        :model="user"
        :rules="rules"
        ref="userform"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="身份证号" prop="identity">
          <el-input size="medium" prefix-icon="el-icon-user" v-model="user.identity" placeholder="身份证号" style="width:300px"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input size="medium" prefix-icon="el-icon-lock" v-model="user.password" placeholder="密码" style="width:300px" show-password></el-input>
        </el-form-item>

        <el-form-item>
          <el-button style="margin-top = 50px; margin-left = 50px ;margin-right:50px" type="primary" @click="login" size="medium">登录</el-button>
          <el-button style="margin-top = 50px; margin-right:30px" type="warning" @click="register" size="medium">注册</el-button>
          <el-button @click="resetForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      user: {
        identity: "",
        password: ""
      },
      rules: {
        identity: [
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
      this.$refs['userform'].validate((valid) => {
        if(valid){
          this.request.post("/user/login", this.user).then(res => {
            console.log(res)
            if(res.code === 200){
              localStorage.setItem("user", JSON.stringify(res.data))
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
    register(){
      this.$router.push("/register")
    },
    resetForm(){
      this.user.identity = ""
      this.user.password = ""
    }
  },
};
</script>

<style scoped>
h3{
  margin-left: 100px;
  font-size: 30px;
}
.wrapper-form {
  width: 500px;
  height: 300px;
  margin: auto;
  margin-top: 200px;
  padding-top: 50px;
  background-color: rgb(243, 243, 175);
  border-radius: 8px;
}
.demo-ruleForm{
  padding: 20px;
  padding-left: 30px;
}
</style>