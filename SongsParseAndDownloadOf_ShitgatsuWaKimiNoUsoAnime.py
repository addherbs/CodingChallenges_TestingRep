from bs4 import BeautifulSoup
import requests
import os

html_text = requests.get('https://anime.thehylia.com/soundtracks/album/shigatsu-wa-kimi-no-uso-op-single-hikaru-nara').text

soup = BeautifulSoup(html_text)
url_list = []
name_list = []
# print ('-------------------------')
for div in soup.findAll('div', attrs={'id':'main'}):
    for table in div.findAll('table', attrs={'style':'border-collapse: collapse'}):
        for anchors in table.findAll('a'):
            url_list.append(anchors['href'])
            name_list.append(anchors.text)


download_link = []

for links in url_list:
    # print ('--------------------------')
    new_text = requests.get(links).text
    soup = BeautifulSoup(new_text)
    for div in soup.findAll('div', attrs={'id':'content_container' , 'class':'clearingfix'}):
        for link in div.findAll('a', attrs= {'style':'color: red;'}):
            download_link.append(link['href'])
            # print (link.text)
count = -1
for download in download_link:
    response = requests.get(download)
    count = count +1
    with open(name_list[count]+".mp3", 'wb') as fp:
        fp.write(response.content)
    os.startfile(name_list[count]+".mp3")
