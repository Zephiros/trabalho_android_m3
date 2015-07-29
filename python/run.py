from flask import Flask, make_response, request, render_template, send_from_directory, redirect, url_for

app = Flask("__main__")

@app.route("/alive", methods=["GET"])
def alive():
    return make_response("Alive", 200)
#    return make_response("", 401, {'WWW-Authenticate': 'Basic realm="Login Required"'})

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=80, threaded=True, debug=True)

