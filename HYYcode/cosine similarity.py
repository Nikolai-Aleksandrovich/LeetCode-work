import time


import sklearn.metrics.pairwise as pw
import numpy as np

def cos_sim(vector_a, vector_b):
    """
    计算两个向量之间的余弦相似度
    :param vector_a: 向量 a
    :param vector_b: 向量 b
    :return: sim
    """
    vector_a = np.mat(vector_a)
    vector_b = np.mat(vector_b)
    num = float(vector_a * vector_b.T)
    denom = np.linalg.norm(vector_a) * np.linalg.norm(vector_b)
    cos = num / denom
    sim = 0.5 + 0.5 * cos
    return sim


def bit_product_sum(x, y):
    return sum([item[0] * item[1] for item in zip(x, y)])


def cosine_similarity(x, y, norm=False):
    """ 计算两个向量x和y的余弦相似度 """
    assert len(x) == len(y), "len(x) != len(y)"
    zero_list = [0] * len(x)
    if x == zero_list or y == zero_list:
        return float(1) if x == y else float(0)

    # method 1
    res = np.array([[x[i] * y[i], x[i] * x[i], y[i] * y[i]] for i in range(len(x))])
    cos = sum(res[:, 0]) / (np.sqrt(sum(res[:, 1])) * np.sqrt(sum(res[:, 2])))

    # method 2
    # cos = bit_product_sum(x, y) / (np.sqrt(bit_product_sum(x, x)) * np.sqrt(bit_product_sum(y, y)))

    # method 3
    # dot_product, square_sum_x, square_sum_y = 0, 0, 0
    # for i in range(len(x)):
    #     dot_product += x[i] * y[i]
    #     square_sum_x += x[i] * x[i]
    #     square_sum_y += y[i] * y[i]
    # cos = dot_product / (np.sqrt(square_sum_x) * np.sqrt(square_sum_y))

    return 0.5 * cos + 0.5 if norm else cos  # 归一化到[0, 1]区间内




def getEdgesFromCSVtoGraph(filePath1,filePath2, lontitudelatitudeArray, mytree, IfPrint):

    start_time = time.time()

    try:
        f = open(filePath1)
    except IOError:
        print("---**---打开文件失败！请检查是否存在该文件！并重新输入文件名!---**---")
    print("filePath:", filePath1)
    TestVectorsCount = 0
    TestitemsCount = 0
    TestVectorList = []
    for line in f.readlines():

        TestitemsCount = TestitemsCount + 1
        if TestitemsCount == 1:
            continue
        else:
            lines = line.strip().split(",")
            TestVectorsCount = TestVectorsCount + 1
            TestVectorList.append(lines)

    TestVectorsArray = np.array(TestVectorList)

    try:
        f = open(filePath2)
    except IOError:
        print("---**---打开文件失败！请检查是否存在该文件！并重新输入文件名!---**---")
    print("filePath:", filePath2)
    TrainVectorsCount = 0
    TrainitemsCount = 0
    TrainVectorList = []
    for line in f.readlines():

        TrainitemsCount = TrainitemsCount + 1
        if TrainitemsCount == 1:
            continue
        else:
            lines = line.strip().split(",")
            TrainVectorsCount = TrainVectorsCount + 1
            TrainVectorList.append(lines)

    TrainVectorsArray = np.array(TrainVectorList)

    # 对其按照第1列排序
    #SortedEdgesArray = edgesArray[edgesArray[:, 0].argsort()]
    # 打印排好序的数组
    # print(SortedEdgesArray)
    # #打印原数组
    # print(edgesArray)

    currentNodeID = ""
    currentCosineSimilarityList = []

    SortedCarList = []
    ValidCount = 0
    for i in TestVectorsArray:
        currentCosineSimilarityList.append(i[0])
        for k in range(1,128):
            currentVector = [i[k]]
        for j in TrainVectorsArray:
            for g in TrainVectorsArray:
                dic = {g[0],}

            currentCosineSimilarityList.append(j[0])
            currentCosineSimilarityList.append(cos_sim())

                    


                    # 其余Weight计算参数
                    x = float(second[9])  # 下一条旅行记录的收入
                    d = haversine(float(first[12]), float(first[13]), float(second[10]),
                                  float(second[11]))  # 一条旅行记录的路程+空车寻客路程
                    if d == 0:
                        d = 1

                    n = 1  # 该时间片内从下一条起点出发的旅途数量

                    # 空车和接到客人的位置信息
                    EmptyAndpickUpPosition = [[float(first[12]), float(first[13])],
                                              [float(second[10]), float(second[11])]]
                    EmptyAndpickUpPositionArray = np.array(EmptyAndpickUpPosition)

                    # 在KDTree中查找空车和接到客人的位置最近的POI，返回最近距离和POI的ID
                    distance, index = queryPoint(mytree, EmptyAndpickUpPositionArray)
                    # print distance, index

                    # TimeNode=0
                    # 从前一条轨迹中得到信息增益
                    # print int(index[1])
                    # print G.nodes[int(index[1])]
                    InformationEntropy = G.nodes[int(index[1])]["InformationEntropy"]
                    if IfPrint == 1:
                        print("InformationEntropy:" + str(InformationEntropy))

                    # 可调参数
                    alpha = 1
                    beta = 1
                    current_total_x = 0
                    current_total_d = 0
                    current_total_trip = 0

                    if G.has_edge(index[0], index[1]):
                        # 存在边就对边的值进行权重加和
                        # current_total_x = nx.get_edge_attributes(G, 'current_total_x') + x
                        # current_total_trip = nx.get_edge_attributes(G,'current_total_trip') + n

                        # G.edges[index[0], index[1]]['current_total_d'] = G.edges[index[0], index[1]][
                        # 'current_total_d'] + d4
                        # G.edges[index[0], index[1]]['weightOfEdge'] = ( x * InformationEntropy * (
                        #                                                           alpha * x /
                        #                                                           n) / (
                        #                                                                   d * beta))
                        G.add_edge(index[0], index[1], weight=G.edges[index[0], index[1]]['weight'] + (
                                    x * InformationEntropy * (
                                    alpha * x /
                                    n) / (
                                            d * beta)))

                        # G.edges[index[0], index[1]]['current_total_x'] = G.edges[index[0], index[1]][
                        #                                                         'current_total_trip'] + x
                        # G.edges[index[0], index[1]]['current_total_trip'] = G.edges[index[0], index[1]]['current_total_trip'] + n
                        # G.edges[index[0], index[1]] ['weightOfEdge'] = (
                        #         G.edges[index[0], index[1]]['current_total_trip'] * InformationEntropy * (
                        #         alpha * G.edges[index[0], index[1]]['current_total_x'] /
                        #         G.edges[index[0], index[1]]['current_total_trip']) / (
                        #                 G.edges[index[0], index[1]]['current_total_d'] * beta))
                    else:
                        # 不存在边就添加边
                        G.add_edge(index[0], index[1],
                                   weight=(n * InformationEntropy * alpha * x / n) / (d * beta))
                    if G.edges[index[0], index[1]]['weight'] == 0.0:
                        G.edges[index[0], index[1]]['weight'] = 0.000000001
                        # G.add_edge(index[0], index[1], current_total_x=x, current_total_d=d, current_total_trip=n,
                        #            weightOfEdge=(n * InformationEntropy * alpha * x / n) / (d * beta))
            currentCarID = i[0]  # SortedCarList.append(SortedcurrentCarArray))#一个新的CarID)
            currentCarList = [i]

    # 对最后一个array进行排序
    if len(currentCarList) != 0 and len(currentCarList) != 1:
        # 如果车辆的行驶轨迹只有一条数据，那么这一条算无效数据
        ValidCount = ValidCount + len(currentCarList)
        currentCarArray = np.array(currentCarList)
        # print currentCarArray
        # 对其按照第6列排序
        SortedcurrentCarArray = currentCarArray[currentCarArray[:, 5].argsort()]
        if IfPrint == 1:
            print("--------" + str(currentCarID) + "-----------------")
            print(SortedcurrentCarArray)

        # SortedCarList.append(SortedcurrentCarArray)
    # SortedCarArray=np.array(SortedCarList)
    # print SortedCarArray

    end_time = time.time()
    cost_time = (end_time - start_time)

    print("The number of edges:" + str(EdgesCount))
    print("The number of valid edges:" + str(ValidCount))
    print('Total time spent on loading car data {:.5f} second.'.format(cost_time))
    print("--------Done!--------")
    return G

