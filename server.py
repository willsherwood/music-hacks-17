from flask import Flask
from flask import request
from flask import send_from_directory
from flask import render_template

import subprocess

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/compile', methods=['POST', 'GET'])
def compile():
    # subprocess.Popen('lilypond', shell=True, stdout=subprocess.PIPE).stdout.read()
    return 'hello miles'

@app.route('/js/<path:path>')
def send_js(path):
    return send_from_directory('js', path)

@app.route('/css/<path:path>')
def send_css(path):
    return send_from_directory('css', path)

@app.route('/fonts/<path:path>')
def send_fonts(path):
    return send_from_directory('fonts', path)

if __name__ == '__main__':
    app.run()
