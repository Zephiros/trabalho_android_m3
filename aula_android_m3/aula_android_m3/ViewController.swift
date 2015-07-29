//
//  ViewController.swift
//  aula_android_m3
//
//  Created by Nicholas Meschke on 7/28/15.
//  Copyright (c) 2015 Nicholas Meschke. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var buttonLocked: UIButton!
    @IBOutlet weak var buttonUnlock: UIButton!
    
    @IBOutlet weak var receive: UITextField!
    @IBOutlet weak var labelLost: UILabel!

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        buttonLocked!.enabled = false
        labelLost.text = ""
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    @IBAction func text(sender: UIButton) {
        sender.enabled = false
        buttonUnlock!.enabled = false
        labelLost!.enabled = false
        receive!.enabled = false
        labelLost.text = "YOU JUST LOST THE GAME"
    }

    @IBAction func unlockButton(sender: UIButton) {
        let urlPath: String = "http://localhost/unlock/" + receive.text
        var url: NSURL = NSURL(string: urlPath)!
        var request: NSURLRequest = NSURLRequest(URL: url)
        var response: NSURLResponse?
        
        var data = NSURLConnection.sendSynchronousRequest(request, returningResponse: &response, error: nil) as NSData?
        
        if let httpResponse = response as? NSHTTPURLResponse {
            if httpResponse.statusCode == 200 {
                buttonLocked!.enabled = true
                labelLost.text = "Yay!"
            }else{
                labelLost.text = "Incorrect Password"
            }
        }
    }
    
    func connection(connection: NSURLConnection!, didReceiveData data: NSData!) {

    }
    
    func connectionDidFinishLoading(connection: NSURLConnection!) {

    }
}

