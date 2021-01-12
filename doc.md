# 基本数据类型

## User 用户

```java
public class User{
    @Id
    @Column(length = 32)
    String username; // 主键
    @Column(length = 64)
    String password;
    @Column(length = 64)
    String address;
}
```

## Book 书

```java
public class Book{
    @Id
    @Column(name = "ISBN", length = 255)
    String ISBN;// 主键
    @Column(length = 64)
    String bookname;
    @Column(length = 64)
    String bookauthor;
    float price;
    int soldnum;//卖出的数量
    int remainnum;//剩余数量
    @CreationTimestamp // 自动添加，无需传递
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private Date shelftime;//上架时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    Date releasetime;//发售时间
    // picturelink : https://i.loli.net/2020/10/23/3GRZheF49UrqjmY.png
    String picturelink;//图片链接
    @Column(columnDefinition="text")
    String text;//简介或者
}
```

## Records 购买记录

```java
public class Records{
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;
    @Column(length = 32)
    String buyername; // mapping to username
    @CreationTimestamp // 自动添加，无需传递
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    Date purchasedate;
    float payfor;
    @Column(length = 255)
    String ISBN;
}
```

# 后端接口

返回值为整数，小于 0 操作失败，等于 0 传输对象为空操作失败，等于 1 成功；

返回 `List<xx>` 对应前端 `JSON` 数组

## 对于 Book

| op   | 接口名          | 参数类型                  | 返回值类型  | 说明                         |
| ---- | --------------- | ------------------------- | ----------- | ---------------------------- |
| 0    | addBook         | Book                      | int         | 添加新书                     |
| 1    | sell            | Book                      | int         | 卖书                         |
| 2    | updateRemainNum | Book                      | int         | 进货，增加书的库存           |
| 3    | updateByISBN    | String                    | int         | 通过 ISBN 修改书的信息       |
| 4    | queryByISBN     | String                    | Book        | 通过 ISBN 查询书的信息       |
| 5    | queryBooks      | int, int                  | List\<Book> | 通过索引批量查询书           |
| 6    | queryByOrder    | int, int, String, boolean | List\<Book> | 根据某个属性排序后批量查询书 |
| 7    | likeQuery       | Book                      | List\<Book> | 模糊查询                     |

## 对于 User

| op   | 接口名       | 参数类型     | 返回值类型 | 说明                 |
| ---- | ------------ | ------------ | ---------- | -------------------- |
| 0    | login        | User         | int        |                      |
| 1    | register     | User         | int        |                      |
| 2    | updateName   | User, User   | int        | 修改用户的用户名     |
| 3    | updatePass   | User, String | int        | 修改用户的密码       |
| 4    | updateAddr   | User, String | int        | 修改用户的地址       |
| 5    | update       | User, User   | int        | 修改用户的所有信息   |
| 6    | updateNoName | User         | int        | 修改除用户名外的信息 |

## 对于 Record

| op   | 接口名           | 参数类型       | 返回值类型    | 说明                     |
| ---- | ---------------- | -------------- | ------------- | ------------------------ |
| 0    | addRecord        | String, String | int           | 插入一条交易信息         |
| 1    | deleteUserRecord | String         | int           | 删除该用户的所有交易信息 |
| 2    | findUserRecords  | String         | List\<Record> | 查询该用户的所有交易信息 |
| 3    | deleteBookRecord | String         | int           | 删除该书的所有交易信息   |
| 4    | findBookRecords  | String         | List\<Record> | 查询该书的所有交易信息   |



# POST 数据交互

直接使用 `JSON` 传输

## 用户交互

```java
public class UserJSON {
    /**
     * -1 no operation
     * 0 login, just one user
     * 1 register, just one user
     * 2 update user's username, two elements in users, users[0]=new, users[1]=old
     *      for old one, just username is required
     *      for new one, just username is required
     * 3 update user's password, one element just
     *      username and password are required, password is the new one
     * 4 update user's address, one element
     *      username and address are required
     * 5 update user's username and other, two elements
     *      for old one, just username is required
     *      for new one, username and password/address are required
     * 6 update user's password or/and address, one element
     *      username, password/address are required
     */
    int opType;
    List<User> users;
}
```

交互传输 `xxJSON` 对象，后端返回值与操作相关

一般来说，修改增加删除，返回值为整数，小于 0 操作失败，等于 0 传输对象为空操作失败，等于 1 成功；

查询操作返回单个数据或者 `List<xx>`

### 操作请求

注意 请求 `url` 的区别

![image-20210110152148441](.\1.assets\image-20210110152148441.png)

### 用户注册

`post man` 用于展示前端向后端请求的格式（在浏览器中 `url`）

包括用户名和密码

![image-20210109204300740](.\1.assets\image-20210109204300740.png)

以下两种方式可用，但为了统一格式，弃用（下文同理），统一使用 `JSON` 传输

![image-20210109204330298](.\1.assets\image-20210109204330298.png)

![image-20210109204345978](.\1.assets\image-20210109204345978.png)

password 需要加密，目前使用基础加密（对密码的每个字符进行异或运算如，`for(char c: pass) c=c^key`, 其中 `key` 前后端统一即可。

### 登录

包括用户名和密码

![image-20210109210758069](C:\Users\cwang\Desktop\1.assets\image-20210109210758069.png)

![image-20210109210836443](.\1.assets\image-20210109210836443.png)

![image-20210109210906189](.\1.assets\image-20210109210906189.png)

## 书籍交互

```java
public class BookJSON {
    /**
     * -1 no operation
     * 0 add a book
     *      book is requried and must be completed
     * 1 sell a book
     *      book is requried and ISBN is requried
     * 2 purchase one book(maybe not use)
     *      book is requried and ISBN and a new remain num are requried
     * 3 update a book
     *      book is requried and must be completed
     * 4 query by ISBN
     *      book is requried and just ISBN is requried
     * 5 query books by index
     *      queryFrom is query starts from where
     *      queryNum is how many are queried
     * 6 query books by order
     *      queryFrom is query starts from where
     *      queryNum is how many are queried
     *      order is sort rules which is must be an attribute in class Book
     *      isAsc is true when sorting in ascending order
     * 7 likely query by isbn or/and bookname or/and bookauthor
     *      book {isbn,bookname,bookauthor}
     * 
     * important: because of the JSON object contain a entity, so the 'book' should be a list
     *  for example:
     *  {
     *      "opType": -1,
     *      "book":[{
     *            "isbn": "111"
     *       }]
     *  }
     */
    int opType;
    int queryFrom;
    int queryNum;
    String order;
    boolean isAsc;
    Book book;
}
```

### 操作请求

请求格式相同，参照 `BookJSON` 注释

![image-20210112211641999](C:\Users\cwang\Desktop\1.assets\image-20210112211641999.png)

## 交易交互

```java
public class RecordJSON {
    /**
     * -1 no operation
     * 0 add a record
     *      ISBN is which book will be traded
     *      username is who will trade
     * 1 delete records by username
     *      username(who will clear his/her records or who will be deleted)
     * 2 find records by username
     *      username
     * 3 delete records by isbn
     *      ISBN(which book will be deleted)
     * 4 find records by isbn
     *      ISBN
     */
    int opType;
    String ISBN;
    String username;
}
```

### 操作请求

![image-20210112212307671](C:\Users\cwang\Desktop\1.assets\image-20210112212307671.png)