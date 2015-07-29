from flask import Flask, make_response, request, render_template, send_from_directory, redirect, url_for

app = Flask("__main__");

@app.route("/alive", methods=["GET"])
def alive():
    return make_response("Alive", 200);

@app.route("/unlock/<string:key>", methods=["GET"])
def unlock(key):
    if key == "senha":
        return make_response("Unlocked", 200);
    return make_response("Do you think that? It's so 'obivio'", 500);

if __name__ == '__main__':
    app.run(host="0.0.0.0", port=80, threaded=True, debug=True);

