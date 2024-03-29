const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm329z2/",
            name: "ssm329z2",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm329z2/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "流浪动物救助系统的设计与实现"
        } 
    }
}
export default base
