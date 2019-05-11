# Algorithms
常用数据结构和算法的java实现

## Sort-排序算法

### 选择排序

#### 思想
首先, 寻找数组中最小的一个元素, 与第一个元素交换位置, 然后在剩下的元素中重复上述操作,
直到遍历全部数组元素

#### 特点
1. 运行时间与输入无关: 无论输入数组有序或者无序, 为了找出最小元素都需要遍历数组
2. 数据移动次数最少: 交换元素的次数与数组大小成正比

### 插入排序

#### 思想
遍历数组中的所有元素, 并与该元素之前的所有元素进行比较, 若小于前一位元素则进行交换, 直到遍历全部数组元素

#### 特点
1. 运行时间取决于数组中的元素的初始顺序: 若数组的元素大部分有序则速度很快, 反之就会很慢, 例如逆序数组


### 希尔排序

#### 思想
因为插入排序每次只能将一个元素移动一位, 因此对于大型乱序数组速度很慢, 而希尔排序改进了插入排序,
交换间隔为h的元素, 实现h数组有序, 并不断将h递减到1, 最后就是使用插入排序完成数组排序

#### 特点
1. 对于大型数组也具有相当不错的速度, 性能基本不会因为数组初始排序受到影响
2. 如何选择h的递增数列会对性能产生影响

### 归并排序

#### 思想
归并: 即将两个有序数组归并成一个更大的有序数组, 归并排序属于递归排序算法, 通过不断将一个数组分割成更小的数组,
然后再进行归并实现数组排序

#### 特点
1. 运行时间与NlgN成正比, 可以应用于百万级别的数组排序
2. 同时需要大小为N的辅助数组

### 快速排序

#### 思想
快速排序的关键在于对数组进行"切分", 首先随意的选取切分元素, 然后从数组的左边开始寻找第一个大于它的元素,
然后从数组的右边开始寻找第一个小于它的元素, 之后交换这两个元素, 当遍历完数组时就可以保证,
切分元素左边的元素都不大于它, 右边的元素都不小于它, 然后对两边的子数组数组进行递归,
最终就可以实现数组排序

#### 特点
1. 原地排序: 不同于归并排序需要大量的额外空间, 快速排序只需要一个很小的辅助栈, 即可进行
2. 运行时间与NlgN成正比
3. 排序性能依赖切分效果, 因此需要对数组进行乱序处理, 避免切分位置落在靠近数组边界的位置
