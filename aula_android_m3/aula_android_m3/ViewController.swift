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
    @IBOutlet weak var receive: UITextField!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        buttonLocked!.enabled = false
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }



    @IBAction func unlockButton(sender: UIButton) {
        let urlPath: String = "http://localhost/alive"
        var url: NSURL = NSURL(string: urlPath)!
        var request: NSURLRequest = NSURLRequest(URL: url)
        var response: NSURLResponse?
        
        var data = NSURLConnection.sendSynchronousRequest(request, returningResponse: &response, error: nil) as NSData?
        
        if let httpResponse = response as? NSHTTPURLResponse {
            if httpResponse.statusCode == 200 {
                buttonLocked!.enabled = true
//                httpResponse.
//                receive!.text
                    = "recebi"
            }
        }
    }
    
    func connection(connection: NSURLConnection!, didReceiveData data: NSData!) {

    }
    
    func connectionDidFinishLoading(connection: NSURLConnection!) {

    }
}

