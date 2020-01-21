#import os
#def open_app(app_dir):
#    os.startfile(app_dir) #os.startfile（）打开外部应该程序，与windows双击相同
#if __name__ == "__main__":
#    app_dir = r'C:\Users\gh\Desktop\PanDownload_v2.1.2\PanDownload\PanDownload.exe'#指定应用程序目录
#    open_app(app_dir)


import speech_recognition as sr
import sys

#say = '你看看'
r = sr.Recognizer()

# 本地语音测试
harvard = sr.AudioFile('C:\\Users\\gh\\Desktop\\bbc0102_2509557LDq.wav')
with harvard as source:
    # 去噪
    r.adjust_for_ambient_noise(source, duration=0.2)
    audio = r.record(source)

# 语音识别
test = r.recognize_google(audio, language="cmn-Hans-CN", show_all=True)
print(test)

# 分析语音
flag = False
for t in test['alternative']:
    print(t)
    if say in t['transcript']:
        flag = True
        break
if flag:
    print('Bingo')