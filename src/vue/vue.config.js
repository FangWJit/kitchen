module.exports = {
    publicPath: process.env.NODE_ENV === 'production' ? './' : '/',
    outputDir: "dist", // 输出文件目录
    lintOnSave: false, // eslint 是否在保存时检查
    assetsDir: 'static', // 配置js、css静态资源二级目录的位置
    devServer: {
        proxy:{
            // 代理接口
            '/accept':{
                target: 'http://localhost:8045/kitchen/userDetail/static',
                changeOrigin: true,
                pathRewrite:{
                    '^/accept':'/'
                }

            }
        }
    }

}