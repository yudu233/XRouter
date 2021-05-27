### 基于ARouter实现startActivityForResult的链式调用


##### 1.添加依赖和配置
```
android {
    defaultConfig {
        ...
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [AROUTER_MODULE_NAME: project.getName()]
            }
        }
    }
}

dependencies {
    // 替换成最新版本, 需要注意的是api
    // 要与compiler匹配使用，均使用最新版可以保证兼容
    implementation 'com.alibaba:arouter-api:1.5.1'
    annotationProcessor 'com.alibaba:arouter-compiler:1.5.1'
    ...
}

```

##### 2.目标页面添加注解
```
@Route(path = "/group/path")
public class SelectContactActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

##### 3.初始化SDK
```
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();      // 打印日志
        ARouter.openDebug();    // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);     // 尽可能早，推荐在Application中初始化
    }
}
```

##### 4.startActivityForResult使用方式



4.1 声明Navigator接口

```java
public interface AppNavigator {
    String _selectPage = "/select/contactActivity";

    //声明返回类型为Navigator<T>, T为需要解析的回传数据类型
    @Route(path = _selectPage)
    Navigator<SelectInfo> toSelectContactPage(@Extras Bundle ss);
}
```

4.2 复写onActivityResult方法

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    XRouter.getRouter().getActivityManager().onActivityResult(this, requestCode, resultCode, data);
}
```

4.3 实现Callback，对回传数据进行解析处理

```java
public abstract class ContactSelectInfoCallback extends RouteCallback<SelectInfo> {
    @Override
    public SelectInfo parseData(int requestCode, int resultCode, @NonNull Intent data) {
        return (SelectInfo)data.getSerializableExtra("selectInfo");
    }
}
```

4.4 发起路由

```java
XRouter.getRouter()
        .create(AppNavigator.class)
        .toSelectContactPage(bundle)
        .startActivityForResult(new ContactSelectInfoCallback() {
            @Override
            public void onResponse(@NonNull SelectInfo data) {
                Log.e("Rain", data.getName() + "-----------onResponse--------");
            }
        });
```

