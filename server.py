from flask import Flask
from flask import request
import subprocess

app = Flask(__name__)

@app.route('/')
def index():
    return 'world'

@app.route('/compile', methods=['POST', 'GET'])
def compile():
    # subprocess.Popen('lilypond', shell=True, stdout=subprocess.PIPE).stdout.read()
    return 'hello miles'

if __name__ == '__main__':
    app.run()
