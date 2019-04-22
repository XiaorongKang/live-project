#encoding=utf-8
#pip3 install pymysql
import pymysql
import seaborn as sns
import matplotlib.pyplot as plt
#conda install numpy
import numpy as np
# pip3 install wordcloud
from wordcloud import WordCloud, STOPWORDS
from matplotlib.font_manager import *#如果想在图上显示中文，需导入这个包


def fetch_data():
    conn = pymysql.connect(host='127.0.0.1', port=3306, user='root', passwd='0523', db='lottery', charset='utf8')
    cursor = conn.cursor()
    cursor.execute('select * from chat_record')
    sns.set_style('darkgrid')  # 设置图片为深色背景且有网格线
    conn.close()
    return cursor.fetchall()


def plot_anasis(all_data):
    hour_set = []
    for line in all_data:
        hour_set.append(line[3].timetuple()[3])
    sns.distplot(hour_set, 24, color='lightcoral')
    plt.xticks(np.arange(0, 25, 1.0), fontsize=15)
    plt.yticks(fontsize=15)
    myfont = FontProperties(fname=r'.\Lottery\src\lottery\python\simfang.ttf',size=22)#标题字体样式
    myfont2 = FontProperties(fname=r'.\Lottery\src\lottery\python\simfang.ttf',size=18)#横纵坐标字体样式
    plt.title('聊天时间分布', fontproperties=myfont)
    plt.xlabel('时间段', fontproperties=myfont2)
    plt.ylabel('聊天时间分布', fontproperties=myfont2)
    save_img(plt.gcf(), 'chat_time.png')
    plt.close()


# 词云制作
def word_could_ana(content):
    text = ""
    for line in content:
        text = text + "," + line[6]
    wordcloud = WordCloud(max_words=100,
                          width=1500,
                          height=800,
                          font_step=1,
                          font_path='.\Lottery\src\lottery\python\simfang.ttf').generate(text)
    plt.imshow(wordcloud, interpolation="bilinear")
    plt.axis("off")
    save_img(plt.gcf(), 'analysis.png')
    plt.close()


def save_img(fig, name):
    fig.set_size_inches(15, 8)
    fig.savefig(name, dpi=100)


if __name__ == '__main__':
    print("1. Fetch data!")
    all_data = fetch_data()
    print("2. Fetched data!")
    print("3. Analysis data!")
    plot_anasis(all_data)
    print("3. Analysised data!")
    word_could_ana(all_data)
    print("4. the end!")
