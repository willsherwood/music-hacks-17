from flask import Flask
from flask import request
from flask import send_from_directory
from flask import render_template

import subprocess
import uuid

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/compile', methods=['POST'])
def compile():
    data = list(request.form.keys())[0]
    filename = 'files/' + str(uuid.uuid1().int>>64)
    with open(filename+'.raw', 'w') as f:
        f.write(data)

    subprocess.Popen('java sherwood.Main < ' + filename + '.raw > ' + filename + '.ly', shell=True, stdout=subprocess.PIPE).stdout.read()


    subprocess.Popen('lilypond -dbackend=eps -dresolution=250 --png ' + filename + '.ly', shell=True, stdout=subprocess.PIPE).stdout.read()

    subprocess.Popen('move ' + filename[6:] + '.png files', shell=True, stdout=subprocess.PIPE).stdout.read()


    subprocess.Popen('del ' + filename[6:] + '*', shell=True, stdout=subprocess.PIPE).stdout.read()



    return filename + '.png'

@app.route('/js/<path:path>')
def send_js(path):
    return send_from_directory('js', path)

@app.route('/files/<path:path>')
def send_file(path):
    return send_from_directory('files', path)


@app.route('/css/<path:path>')
def send_css(path):
    return send_from_directory('css', path)

@app.route('/fonts/<path:path>')
def send_fonts(path):
    return send_from_directory('fonts', path)

if __name__ == '__main__':
    app.run()
