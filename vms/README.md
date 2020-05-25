## 模拟自动售货机

模拟真实的自动售货机，程序应提供以下功能。

对于普通消费者：

1. 显示产品名称和价格
2. 指出产品是否缺货
3. 取出硬币
4. 指出投入的硬币是否足以用于某种产品
5. 分配产品
6. 退回硬币并找零

对于服务人员：

1. 允许提取所有已插入的硬币
2. 允许重新填充产品
3. 允许显示其他产品

### 菜单

![image](/Users/liyi/works/repos/shengtang-se/vms/img/menu_map.png)

#### 流程

程序启动时，打印自动售货机的货品展示。然后显示主菜单。

```
*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [ ]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 0]  |
|                           |
|           [===]           |
*---------------------------*

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit
```

当输入无效选择时，程序提示错误并保持循环。如下

```
What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:8
Invalid choice!

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:
```

#### 1. Read product information

如果选择选项1，将显示产品名称和相应的价格。然后再次显示主菜单。

```
What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:1

(1) The displayed products are:
A. Juice ($10)
B. Cola ($6)
C. Tea ($5)
D. Water ($8)
E. Coffee ($7)

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:
```

## 2. Insert coin

如果选择了选项2，则应显示带有可用硬币选项的子菜单。投入硬币后，应显示自动售货机的产品界面，并显示放入硬币的总价格（最大值：99），然后再次显示子菜单。 （机器开始时金额为$ 0。）

```
(2) Which coin would you like to insert?
 1. $1
 2. $2
 3. $5
 4. $10
 0. Go back

Your choice:2
You have inserted $2.

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [ ]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 2]  |
|                           |
|           [===]           |
*---------------------------*

(2) Which coin would you like to insert?
 1. $1
 2. $2
 3. $5
 4. $10
 0. Go back

Your choice:
```

如果投入的钱足以购买某种产品，请用大写的“O”表示“开灯”。

```
(2) Which coin would you like to insert?
 1. $1
 2. $2
 3. $5
 4. $10
 0. Go back

Your choice:3
You have inserted $5.

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [O]  [O]  [ ]  [O]  |
*---------------------------*
|                    [$ 7]  |
|                           |
|           [===]           |
*---------------------------*

(2) Which coin would you like to insert?
 1. $1
 2. $2
 3. $5
 4. $10
 0. Go back

Your choice:
```

选择选项0（返回）将显示自动售货机，然后返回主菜单。

```
(2) Which coin would you like to insert?
 1. $1
 2. $2
 3. $5
 4. $10
 0. Go back

Your choice:0
Going back!

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [O]  [O]  [ ]  [O]  |
*---------------------------*
|                    [$ 7]  |
|                           |
|           [===]           |
*---------------------------*

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:
```

#### 3. Press product button

如果选择了选项3，则应显示带有可用产品选项的子菜单。如果存入的钱足以购买所选的产品，则产品售出。自动售货机的底部显示产品标识，同时刷新按钮灯和余额，然后显示主菜单。 （假设机器存入了7美元，购买了产品B，然后B产品售罄。）

```
(3) Which product button would you like to press?
 1. A
 2. B
 3. C
 4. D
 5. E
 0. Go back

Your choice:2
You have pressed button B.

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [X]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 1]  |
|                           |
|           [=B=]           |
*---------------------------*

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:
```

请注意，产品B以售完。现在按钮上有一个"X"。另请注意，剩余的存入金额将不会自动退还。不能购买已经售罄的产品。

如果按了缺货或价格大于余额的产品的按钮，则给与无效的提示，然后让用户重新选择

```
Your choice: 3

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [O]  [O]  [ ]  [O]  |
*---------------------------*
|                    [$ 7]  |
|                           |
|           [===]           |
*---------------------------*

(3) Which product button would you like to press?
 1. A
 2. B
 3. C
 4. D
 5. E
 0. Go back

Your choice:1
You have pressed button A.
invalid choice

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [X]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 1]  |
|                           |
|           [===]           |
*---------------------------*

(3) Which product button would you like to press?
 1. A
 2. B
 3. C
 4. D
 5. E
 0. Go back
 
 Your choice:
```

#### 4. Press return button

如果选择了选项4，则将退还所有余额。应显示自动售货机界面，然后再次显示主菜单。

```
(4) Return button is pressed.
$1 has been returned.

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [X]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 0]  |
|                           |
|           [===]           |
*---------------------------*

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:
```

#### 9. Service menu

如果选择了选项9，则要求用户输入访问密码（默认值：1110）。输入错误密码，给与错误消息后，将返回售货机面板并显示主菜单。

```
(9) Opening service menu. Access code is required.
Enter access code: 1234
Incorrect code!

*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [X]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 0]  |
|                           |
|           [===]           |
*---------------------------*

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:
```

输入密码正确后，将访问服务菜单

```
(9) Opening service menu. Access code is required.
Enter access code: 1110
Correct code!

(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:
```

#### 9-1. Inspect machine status

如果在服务菜单中选择了选项1，则将显示有关收入（所有售出产品的总金额），已投入硬币（已投入但未使用的硬币余额）和产品的信息。然后再次显示服务菜单。

```
(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:
1
(9-1) Machine status
Amount of revenue: $6
Amount of inserted coins: $0
A. Juice ($10) (5 left)
B. Cola ($6) (sold out)
C. Tea ($5) (2 left)
D. Water ($8) (1 left)
E. Coffee ($7) (9 left)

(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:
```

#### 9-2. Withdraw all money

如果在服务菜单中选择了选项2，则将提取机器中的所有货币（包括已投入但未使用的硬币）。然后再次显示服务菜单。

```
(9-2) All money is being withdrawn.
$6 is withdrawn.

(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:2

(9-2) All money is being withdrawn.
$0 is withdrawn.

(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:
```

#### 9-3. Refill product

如果在服务菜单中选择了选项3，将显示一个子菜单，供用户选择要补充库存到全部数量的产品（固定为10）。然后将再次显示服务菜单。

```
(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:3

(9-3) Which product would you like to refill?
 1. A
 2. B
 3. C
 4. D
 5. E
 0. Go back

Your choice:2
You have refilled product B to full.

(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:
```

#### 9-4. Change product

如果在服务菜单中选择了选项4，将显示一个子菜单供用户选择要更改的产品。

```
(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:4

(9-4) Which product would you like to change?
 1. A
 2. B
 3. C
 4. D
 5. E
 0. Go back

Your choice:5
You are changing product E.
```

#### 9-4-1. Changing product

选择产品后，提示用户输入新产品名称（最多20个字符，没有空格）和新产品价格（$1-$99）。产品数量将被填满。然后再次显示服务菜单。

```
Enter new product name:Milk
Enter new product price:4
The new product E has been filled to full.

(9) What would you like to do?
 1. Inspect machine status
 2. Withdraw all money
 3. Refill product
 4. Change product
 0. Go back

Your choice:
```

#### 0. Quit

如果在顶部菜单中选择了选项0，程序将终止。

```
*---------------------------*
|     Vending   Machine     |
*---------------------------*
|   A    B    C    D    E   |
|  $10  $ 6  $ 5  $ 8  $ 7  |
|  [ ]  [ ]  [ ]  [ ]  [ ]  |
*---------------------------*
|                    [$ 0]  |
|                           |
|           [===]           |
*---------------------------*

What would you like to do?
 1. Read product information
 2. Insert coin
 3. Press product button
 4. Press return button
 9. Open service menu (code required)
 0. Quit

Your choice:0


Process finished with exit code 0
```

## 假设和初始条件

可以在程序执行期间安全地假定以下条件。

1. 来自用户的所有菜单输入均为整数。
2. 所有产品名称最多可包含20个字符，并且之间不能有空格。
3. 所有产品价格都在$1到$99之间。展示售货机面板时，个位数金额，显示为`$ 0`。机器上显示两位数的金额时，将显示为`$10`。在消息中显示时，在两种情况下，`$`后都没有空格。
4. 投入硬币的总金额最大为$99。如果投入的金额超过$ 99，则就认为金额是$99
5. 服务菜单（选项9）的访问代码将输入为整数，并将被视为整数。因此，输入的代码1110和001110都将授予访问权限。
6. 更改产品时（操作9-4-1），新输入的产品名称和价格将遵循上述假设（2）和（3）。
7. 新输入的产品名称和价格将显示在产品信息（在主菜单中）和检查机器状态（在服务菜单中）中，直到程序终止。
8. 无需在程序执行之间保留机器状态（即收入，插入的硬币，产品名称和价格）。每次程序启动时，都应将其重置为初始条件（如下所述）。

每次程序启动时，自动售货机应具有以下初始条件。

- 收入金额：$ 0
- inserted投入的硬币数量：$ 0
- 产品信息：
  A. Juice ($10) (5 left)
  B. Cola($6)(1left)
  C. Tea ($5) (2 left)
  D. Water ($8) (1 left)
  E. Coffee ($7) (9 left)