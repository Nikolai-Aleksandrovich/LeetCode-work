# coding=utf-8
def top5_word_lengths(text):
    text = text.split()  # 分割语句，方便放入
    newdict = {}  # 把句子中的词语统计频率后放入字典
    anslist = []  # 答案数组
    for i in text:  # 遍历语句
        if len(i) in newdict:  # 如果这个key值存在，那么value值+1
            newdict[len(i)] += 1
        else:  # 如果这个key值不存在，那么设置一个 key-value的对，设置value值为1
            newdict[len(i)] = 1
    sortedDict = sorted(newdict.iteritems(), key=lambda x: (x[1], x[0]))  # 对前边的newdict按照首先value值排序，当value值相等，按照key值排序
    templist = list(reversed(sortedDict))  # 刚刚排序的结果其实是从小到大的升序，答案要求从大到小的降序，类似这样：[(3,1),(9,1),(5,
    # 3)]，一个列表，其中的元素是tuple，反转列表得到templist
    if len(templist) > 5:  # 判断长度。超过五，就取最大的5个，不然就全取
        for i in range(0, 5):
            anslist.append(templist[i][0])
    else:
        for i in templist:
            anslist.append(i[0])
    return list(set(newdict))


text_longer_than_5 = "one one was a racehorse two two awdaw asdasd asdasd asdasd asdasd aweqr asdaszc asdqw asdasd"
text_shorter_than_5 = "one one was a racehorse two two"
top5_word_lengths(text_longer_than_5)
top5_word_lengths(text_shorter_than_5)
